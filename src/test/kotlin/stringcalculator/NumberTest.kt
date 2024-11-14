package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberTest : StringSpec({
    "소수 첫째 자리까지만 표현한다." {
        val number = Number(1.254)
        number.amount shouldBe 1.3
    }

    "표현 가능한 범위는 -1억 ~ 1억으로 고정한다." {
        assertThrowsForInvalidNumber(-1_0000_0001.0)
        assertThrowsForInvalidNumber(1_0000_0001.0)
    }

    "더할 수 있다." {
        val numberA = Number(1.0)
        val numberB = Number(2.0)
        val result = numberA.plus(numberB)
        result.amount shouldBe Number(3.0).amount
    }

    "뺄 수 있다." {
        val numberA = Number(3.0)
        val numberB = Number(4.0)
        val result = numberA.minus(numberB)
        result.amount shouldBe Number(-1.0).amount
    }

    "곱할 수 있다." {
        val numberA = Number(5.6)
        val numberB = Number(7.8)
        val result = numberA.times(numberB)
        result.amount shouldBe Number(43.7).amount
    }

    "나눌 수 있다." {
        val numberA = Number(9.0)
        val numberB = Number(10.0)
        val result = numberA.div(numberB)
        result.amount shouldBe Number(0.9).amount
    }

    "0으로 나눌 수 없다." {
        val numberA = Number(1.0)
        val numberB = Number(0.0)
        val exception =
            shouldThrowExactly<IllegalArgumentException> {
                numberA.div(numberB)
            }
        exception.message shouldBe "0으로 나눌 수 없습니다."
    }

    "나눗셈의 결과는 소수 둘째 자리에서 반올림한다." {
        val numberA = Number(1.0)
        val numberB = Number(3.0)
        val result = numberA.div(numberB)
        result.amount shouldBe Number(0.3).amount
    }
})

private fun assertThrowsForInvalidNumber(value: Double) {
    val exception =
        shouldThrowExactly<IllegalArgumentException> {
            Number(value)
        }
    exception.message shouldBe "숫자의 범위는 -1억 이상 1억 이하 입니다."
}
