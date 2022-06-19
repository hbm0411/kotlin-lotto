package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoScore {
    fun compareNumber(winningLotto: WinningLotto, lottoTickets: List<LottoTicket>): List<LottoResult> {
        val winningTicket = winningLotto.winningTicket
        val bonusNumber = winningLotto.bonusNumber

        val matchResults = lottoTickets.map { lottoTicket ->
            lottoTicket.countIntersection(winningTicket) to lottoTicket
        }

        val thirdResults = matchResults.filter { it.first == LottoPrize.THIRD.matchCount }.map { it.second }
        val secondCount = isSecond(thirdResults, bonusNumber)

        val matchGroupingResults = matchResults.groupingBy { it.first }.eachCount()

        return LottoPrize.values().map { lottoPrize ->
            val lottoCount = matchGroupingResults.getOrDefault(lottoPrize.matchCount, 0)
            val count = when (lottoPrize) {
                LottoPrize.SECOND -> secondCount
                LottoPrize.THIRD -> lottoCount - secondCount
                else -> lottoCount
            }
            LottoResult(lottoPrize, count)
        }
    }

    private fun isSecond(lottoTickets: List<LottoTicket>, bonusNumber: LottoNumber): Int =
        lottoTickets.filter { bonusNumber in it }.size

    fun rateOfResult(lottoPrice: LottoPrice, lottoResults: List<LottoResult>): BigDecimal {
        val realLottoPrice = lottoPrice / LottoPurchase.LOTTO_PRICE * LottoPurchase.LOTTO_PRICE
        return BigDecimal(sumOfResult(lottoResults)).divide(BigDecimal(realLottoPrice), 2, RoundingMode.HALF_UP)
    }

    private fun sumOfResult(lottoResults: List<LottoResult>): Int = lottoResults.sumOf {
        it.lottoPrize.prizeMoney * it.lottoCount
    }
}
