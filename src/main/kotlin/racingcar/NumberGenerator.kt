package racingcar

fun interface NumberGenerator {
    fun generate(): Int
}

fun NumberGenerator.generateWithValidation(): Int {
    val value = generate()
    require(value in 0..9) { "생성되는 숫자는 0에서 9 사이의 값이어야 합니다." }
    return value
}
