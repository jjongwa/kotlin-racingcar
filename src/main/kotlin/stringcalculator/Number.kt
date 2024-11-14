package stringcalculator

class Number(value: Double) {
    val amount: Double

    init {
        require(!validateRange(value)) { "숫자의 범위는 -1억 이상 1억 이하 입니다." }
        this.amount = roundToOneDecimalPlace(value)
    }

    private fun validateRange(amount: Double) = (amount < -1_0000_0000 || amount > 1_0000_0000)

    private fun roundToOneDecimalPlace(amount: Double) = String.format("%.1f", amount).toDouble()

    operator fun plus(value: Number): Number {
        return Number(this.amount + value.amount)
    }

    operator fun minus(value: Number): Number {
        return Number(this.amount - value.amount)
    }

    operator fun times(value: Number): Number {
        return Number(this.amount * value.amount)
    }

    operator fun div(value: Number): Number {
        require(value.amount != 0.0) { "0으로 나눌 수 없습니다." }
        return Number(this.amount / value.amount)
    }
}
