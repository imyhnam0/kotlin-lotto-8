package lotto.domain

class LottoResult(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int,
    private val tickets: LottoTicket
) {
    private val results: MutableMap<Rank, Int> = mutableMapOf()

    init {
        validateWinningNumbers()
        calculateResults()
    }

    private fun validateWinningNumbers() {
        LottoNumber.validateList(winningNumbers)
        LottoNumber.validate(bonusNumber)
        LottoNumber.validateUniqueInList(bonusNumber, winningNumbers)
    }

    private fun calculateResults() {
        tickets.getTickets().forEach { lotto ->
            val matchCount = lotto.getNumbers().count { it in winningNumbers }
            val hasBonus = bonusNumber in lotto.getNumbers()
            val rank = Rank.of(matchCount, hasBonus)
            results[rank] = results.getOrDefault(rank, 0) + 1
        }
    }

    fun getResultCounts(): Map<Rank, Int> = results.toMap()

    fun getProfitRate(purchaseAmount: Int): Double {
        val totalPrize = results.entries.sumOf { it.key.prize * it.value }
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}
