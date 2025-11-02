package lotto.controller

import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        try {
            val purchaseAmount = inputView.readPurchaseAmount()
            val tickets = LottoTicket.generateTickets(purchaseAmount)
            outputView.printTickets(tickets)

            val winningNumbers = inputView.readWinningNumbers()
            val bonusNumber = inputView.readBonusNumber()
            val result = LottoResult(winningNumbers, bonusNumber, tickets)

            outputView.printStatistics(result)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            run() // 다시 입력 받기
        }
    }
}
