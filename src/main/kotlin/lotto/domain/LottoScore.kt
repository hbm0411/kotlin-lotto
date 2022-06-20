package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoScore {
    fun compareNumber(winningLotto: WinningLotto, lottoTickets: LottoTickets): LottoResults =
        lottoTickets.get().asSequence()
            .mapNotNull { lottoTicket ->
                val count = lottoTicket.countIntersection(winningLotto.winningTicket)
                val bonusMatch = winningLotto.bonusNumber in lottoTicket

                when (count) {
                    LottoPrize.THIRD.matchCount -> {
                        if (bonusMatch) LottoPrize.SECOND
                        else LottoPrize.THIRD
                    }
                    else -> {
                        LottoPrize.values().firstOrNull() { it.matchCount == count }
                    }
                }
            }.groupingBy { it }.eachCount()
            .map { (LottoPrize, count) -> LottoResult(LottoPrize, count) }
            .toLottoResults()

    fun rateOfResult(lottoPrice: LottoPrice, lottoResults: LottoResults): BigDecimal {
        val realLottoPrice = lottoPrice / LottoPurchase.LOTTO_PRICE * LottoPurchase.LOTTO_PRICE
        return BigDecimal(sumOfResult(lottoResults)).divide(BigDecimal(realLottoPrice), 2, RoundingMode.HALF_UP)
    }

    private fun sumOfResult(lottoResults: LottoResults): Int = lottoResults.get().sumOf {
        it.lottoPrize.prizeMoney * it.lottoCount
    }
}
