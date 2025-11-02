package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Rank
import lotto.domain.LottoTicket
import kotlin.math.round

class OutputView {
    fun printTickets(tickets: LottoTicket) {
        val list = tickets.getTickets()
        println("\n${list.size}개를 구매했습니다.")
        list.forEach { println(it.getNumbers()) }
    }

    fun printStatistics(result: LottoResult) {
        println("\n당첨 통계")
        println("---")
        val results = result.getResultCounts()

        Rank.values()
            .filter { it != Rank.NONE }
            .forEach { rank ->
                val count = results.getOrDefault(rank, 0)
                println("${rank.description} - ${count}개")
            }

        val profitRate = round(result.getProfitRate(1000 * result.getResultCounts().values.sum()) * 10) / 10
        println("총 수익률은 ${profitRate}%입니다.")
    }
}
