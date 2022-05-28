package lotto.view

import lotto.domain.LottoPurchase.Companion.LOTTO_PRICE
import lotto.domain.LottoResult
import lotto.domain.LottoTicket

class OutputView {
    fun cannotPurchaseLotto() {
        println("로또 한개의 가격은 $LOTTO_PRICE 입니다. 그 이상을 입력해 주세요.")
    }

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

    private fun winningLottoResults(lottoResults: List<LottoResult>) = buildString {
        lottoResults.sortedBy { it.lottoPrize.matchCount }
            .forEach {
                appendLine("${it.lottoPrize.matchCount}개 일치 (${it.lottoPrize.prizeMoney}원) - ${it.lottoCount}개")
            }
    }
}
