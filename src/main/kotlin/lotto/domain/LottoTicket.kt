package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoTicket(private val tickets: List<Lotto>) {

    companion object {
        private const val PRICE = 1000

        fun generateTickets(amount: Int): LottoTicket {
            require(amount % PRICE == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }

            val count = amount / PRICE
            val lottoList = List(count) {
                val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
                Lotto(numbers)
            }
            return LottoTicket(lottoList)
        }
    }

    fun getTickets(): List<Lotto> = tickets
}
