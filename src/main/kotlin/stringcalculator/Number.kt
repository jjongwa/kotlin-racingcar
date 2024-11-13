package stringcalculator

class Number(value: Double) {
    val amount: Double

    init {
        require(!validateRange(value)) { "숫자의 범위는 -1억 이상 1억 이하 입니다." }
        this.amount = roundToOneDecimalPlace(value)
    }

    private fun validateRange(amount: Double) = (amount < -1_0000_0000 || amount > 1_0000_0000)

    private fun roundToOneDecimalPlace(amount: Double) = String.format("%.1f", amount).toDouble()
}
