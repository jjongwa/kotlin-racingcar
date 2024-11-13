package stringcalculator

class Calculator(input: String) {
    private val numbers: List<Number>
    private val operators: List<Operator>

    init {
        validateNotBlankInput(input)
        val elements = splitByRegex(input)
        validateNoConsecutiveOperators(elements)

        operators =
            elements.filter { it in "+-*/" }
                .map { Operator.from(it.single()) }
        numbers =
            elements.filter { it !in "+-*/" }
                .map { Number(it.toDouble()) }
        sad(numbers, operators)
    }

    private fun validateNotBlankInput(input: String) {
        require(input.isNotBlank()) { "입력 문자열이 비어 있거나 공백입니다." }
    }

    private fun validateNoConsecutiveOperators(elements: List<String>) {
        for (element in 1 until elements.size) {
            require(!(elements[element - 1] in "+-*/" && elements[element] in "+-*/")) { "두 개 이상의 연산자가 연속해서 나타날 수 없습니다." }
        }
    }

    private fun sad(
        numbers: List<Number>,
        operators: List<Operator>,
    ) {
        require((numbers.size - 1 == operators.size)) { "수식은 숫자 연산자 숫자 순으로 입력되어야 합니다." }
    }

    private fun splitByRegex(input: String): List<String> {
        val cleanedInput = input.replace("\\s".toRegex(), "")
        val regex = "(?<=[-+*/])|(?=[-+*/])".toRegex()
        return regex.split(cleanedInput).filter { it.isNotEmpty() }
    }
}
