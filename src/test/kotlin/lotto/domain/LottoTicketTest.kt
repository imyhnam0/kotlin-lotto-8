package lotto.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `구입 금액이 1000 단위면 올바른 개수의 로또를 발행한다`() {
        val ticket = LottoTicket.generateTickets(8000)
        assertThat(ticket.getTickets()).hasSize(8)
    }

    @Test
    fun `구입 금액이 1000으로 나누어 떨어지지 않으면 예외 발생`() {
        assertThatThrownBy { LottoTicket.generateTickets(5500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `로또 발행 시 모든 번호는 중복되지 않고 1부터 45 사이여야 한다`() {
        val ticket = LottoTicket.generateTickets(2000)
        val allNumbers = ticket.getTickets().flatMap { it.getNumbers() }
        assertThat(allNumbers).allMatch { it in 1..45 }
    }
}
