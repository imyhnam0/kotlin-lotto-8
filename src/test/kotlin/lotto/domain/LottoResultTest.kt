package lotto.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoResultTest {

    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7

    @Test
    fun `6개 번호 일치 시 1등 당첨`() {
        val ticket = LottoTicket(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))))
        val result = LottoResult(winningNumbers, bonusNumber, ticket)
        assertThat(result.getResultCounts()[Rank.FIRST]).isEqualTo(1)
    }

    @Test
    fun `5개 번호 일치 + 보너스 일치 시 2등 당첨`() {
        val ticket = LottoTicket(listOf(Lotto(listOf(1, 2, 3, 4, 5, 7))))
        val result = LottoResult(winningNumbers, bonusNumber, ticket)
        assertThat(result.getResultCounts()[Rank.SECOND]).isEqualTo(1)
    }

    @Test
    fun `수익률이 올바르게 계산된다`() {
        val ticket = LottoTicket(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))))
        val result = LottoResult(winningNumbers, bonusNumber, ticket)
        val rate = result.getProfitRate(1000)
        assertThat(rate).isEqualTo(2_000_000_000.0 / 1000 * 100)
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외 발생`() {
        assertThatThrownBy {
            LottoResult(winningNumbers, 6, LottoTicket(listOf(Lotto(winningNumbers))))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("중복")
    }

    @Test
    fun `당첨 번호가 6개가 아니면 예외 발생`() {
        assertThatThrownBy {
            LottoResult(listOf(1, 2, 3, 4, 5), 7, LottoTicket(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("6개")
    }
}
