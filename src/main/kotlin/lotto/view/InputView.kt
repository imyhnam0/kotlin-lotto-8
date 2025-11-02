package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.")
    }

    fun readWinningNumbers(): List<Int> {
        println("\n당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        return input.split(",").map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자 형식이 잘못되었습니다.")
        }
    }

    fun readBonusNumber(): Int {
        println("\n보너스 번호를 입력해 주세요.")
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.")
    }
}
