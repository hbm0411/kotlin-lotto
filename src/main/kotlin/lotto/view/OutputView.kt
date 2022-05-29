package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import java.math.BigDecimal

class OutputView {
    fun resultPurchaseLotto(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun resultLottoTickets(lottoTickets: List<LottoTicket>) {
        lottoTickets.forEach(::println)
    }

    fun winningResult(lottoResults: List<LottoResult>) {
        val result = buildString {
            appendLine("\n당첨 통계")
            appendLine("---------")
            append(winningLottoResults(lottoResults))
        }
        println(result)
    }

    fun winningRate(rateResult: BigDecimal) {
        println("총 수익률은 ${rateResult}입니다.")
    }

    private fun winningLottoResults(lottoResults: List<LottoResult>) = buildString {
        lottoResults.sortedBy { it.lottoPrize.matchCount }
            .forEach {
                appendLine("${it.lottoPrize.matchCount}개 일치 (${it.lottoPrize.prizeMoney}원) - ${it.lottoCount}개")
            }
    }
}
