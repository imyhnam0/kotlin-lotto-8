package lotto.domain

object LottoNumber {
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45
    private const val COUNT = 6

    fun validate(number: Int) {
        require(number in MIN_NUMBER..MAX_NUMBER) { "[ERROR] 로또 번호는 1부터 45 사이여야 합니다." }
    }

    fun validateList(numbers: List<Int>) {
        require(numbers.size == COUNT) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == COUNT) { "[ERROR] 중복된 번호가 있습니다." }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { "[ERROR] 로또 번호는 1부터 45 사이여야 합니다." }
    }

    fun validateUniqueInList(number: Int, numbers: List<Int>) {
        require(number !in numbers) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }
}
