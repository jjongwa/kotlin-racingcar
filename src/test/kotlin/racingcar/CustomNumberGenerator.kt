package racingcar

class CustomNumberGenerator(private val numbers: MutableList<Int>) : NumberGenerator {
    override fun generate(): Int {
        return numbers.removeFirst()
    }
}
