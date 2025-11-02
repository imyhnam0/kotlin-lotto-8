package lotto.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `6개 일치 시 1등`() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `5개 일치 + 보너스 일치 시 2등`() {
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `5개 일치만 하면 3등`() {
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `4개 일치면 4등`() {
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `3개 일치면 5등`() {
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `2개 이하 일치면 NONE`() {
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NONE)
    }

    @Test
    fun `보너스 여부는 5개 일치일 때만 영향을 준다`() {
        assertThat(Rank.of(4, true)).isEqualTo(Rank.of(4, false))
    }
}
