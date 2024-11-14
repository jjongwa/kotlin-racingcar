package stringcalculator

enum class Operator(val symbol: Char) {
    ADD('+') {
        override fun apply(
            x: Number,
            y: Number,
        ): Number = x.plus(y)
    },
    SUBTRACT('-') {
        override fun apply(
            x: Number,
            y: Number,
        ): Number = x.subtract(y)
    },
    MULTIPLY('*') {
        override fun apply(
            x: Number,
            y: Number,
        ): Number = x.multiply(y)
    },
    DIVIDE('/') {
        override fun apply(
            x: Number,
            y: Number,
        ): Number = x.divide(y)
    }, ;

    abstract fun apply(
        x: Number,
        y: Number,
    ): Number

    companion object {
        fun from(symbol: Char): Operator {
            return entries.first { it.symbol == symbol }
        }
    }
}
