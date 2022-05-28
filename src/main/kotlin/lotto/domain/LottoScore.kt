package lotto.domain

class LottoScore {
    fun compareNumber(winningTicket: LottoTicket, lottoTickets: List<LottoTicket>): List<LottoResult> {
        val matchCounts = lottoTickets.map { lottoTicket ->
            lottoTicket.get().mapNotNull { lottoNumber ->
                winningTicket.get().find { it == lottoNumber }
            }.size
        }

        val compareResult = matchCounts.groupingBy { it }.eachCount()

        return compareResult.map { (matchCount, lottoCount) ->
            LottoPrize.find(matchCount)?.let { LottoPrize ->
                LottoResult(LottoPrize, lottoCount)
            }
        }.filterNotNull()
    }

    fun rateOfResult(lottoPrice: LottoPrice, lottoResults: List<LottoResult>): Double {
        return sumOfResult(lottoResults).toDouble() / lottoPrice.get()
    }

    private fun sumOfResult(lottoResults: List<LottoResult>) = lottoResults.sumOf {
        it.lottoPrize.prizeMoney * it.lottoCount
    }
}
