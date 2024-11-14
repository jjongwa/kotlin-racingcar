package stringcalculator

fun main() {
    println("계산할 수식을 입력하세요.")
    val input: String = readln()
    val result = Calculator(input).calculate()
    println(result)
}
