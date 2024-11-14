package stringcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorApplicationKtTest : StringSpec({
    "문자열 계산기 테스트" {
        doCalculate("1+2+3+4") shouldBe "10.0"
        doCalculate("1+2*3/4") shouldBe "2.3"
        doCalculate("1+2*3/4-5") shouldBe "-2.7"
        doCalculate("1+2*3/4-5*6") shouldBe "-16.2"
    }
})

private fun doCalculate(input: String): String {
    return Calculator(input).calculate()
}
