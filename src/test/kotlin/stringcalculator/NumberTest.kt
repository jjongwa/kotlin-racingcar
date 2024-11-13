package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberTest : StringSpec({
    "소수 첫째 자리까지만 표현한다." {
        val number = Number(1.254)
        number.amount shouldBe 1.3
    }

    fun assertThrowsForInvalidNumber(value: Double) {
        val exception =
            shouldThrowExactly<IllegalArgumentException> {
                Number(value)
            }
        exception.message shouldBe "숫자의 범위는 -1억 이상 1억 이하 입니다."
    }

    "표현 가능한 범위는 -1억 ~ 1억으로 고정한다." {
        assertThrowsForInvalidNumber(-1_0000_0001.0)
        assertThrowsForInvalidNumber(1_0000_0001.0)
    }
})
