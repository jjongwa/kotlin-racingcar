package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "계산할 수식을 하나의 문자열로 받을 수 있다." {
        val input = "2+3*4/2"
        val calculator = Calculator(input)
    }

    "입력값이 null or 빈 공백 문자가 될 수 없다." {
        assertThrowsForInvalidInput("")
        assertThrowsForInvalidInput(" ")
    }

    "숫자 연산자 숫자 순으로 입력되어야 한다." {
        assertThrowsForInvalidOrder("2+3+")
        assertThrowsForInvalidOrder("/4+56")
        assertThrowsForInvalidOrder("/789+1000*")
    }

    "두 개 이상의 연산자가 연속해서 나타날 수 없다." {
        assertThrowsOnConsecutiveOperators("12*+34")
        assertThrowsOnConsecutiveOperators("56//78")
        assertThrowsOnConsecutiveOperators("2+3/4**5")
    }
})

private fun assertThrowsForInvalidInput(input: String) {
    val exception =
        shouldThrowExactly<IllegalArgumentException> {
            Calculator(input)
        }
    exception.message shouldBe "입력 문자열이 비어 있거나 공백입니다."
}

private fun assertThrowsForInvalidOrder(input: String) {
    val exception =
        shouldThrowExactly<IllegalArgumentException> {
            Calculator(input)
        }
    exception.message shouldBe "수식은 숫자 연산자 숫자 순으로 입력되어야 합니다."
}

private fun assertThrowsOnConsecutiveOperators(input: String) {
    val exception =
        shouldThrowExactly<IllegalArgumentException> {
            Calculator(input)
        }
    exception.message shouldBe "두 개 이상의 연산자가 연속해서 나타날 수 없습니다."
}
