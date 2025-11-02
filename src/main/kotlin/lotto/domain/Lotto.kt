package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        LottoNumber.validateList(numbers)
    }

    fun getNumbers(): List<Int> = numbers.sorted()
}
