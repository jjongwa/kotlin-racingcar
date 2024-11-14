package racingcar

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NumberGeneratorKtTest : StringSpec({
    "원하는 값을 생성할 수 있다." {
        val customNumberGenerator = CustomNumberGenerator(mutableListOf(1, 2, 3))
        customNumberGenerator.generateWithValidation() shouldBe 1
        customNumberGenerator.generateWithValidation() shouldBe 2
        customNumberGenerator.generateWithValidation() shouldBe 3
    }

    "생성된 값은 0 이상 9 이하이다." {
        forAll(
            row(-1),
            row(10),
            row(11),
            row(100),
            row(-5),
        ) { number ->
            val customNumberGenerator = CustomNumberGenerator(mutableListOf(number))
            shouldThrowExactly<IllegalArgumentException> {
                val exception = customNumberGenerator.generateWithValidation()
                exception shouldBe "생성되는 숫자는 0에서 9 사이의 값이어야 합니다."
            }
        }
    }
})
