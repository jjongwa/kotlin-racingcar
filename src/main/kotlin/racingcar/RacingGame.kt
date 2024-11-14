package racingcar

class RacingGame(
    inputCarSize: Int,
    inputRoundCount: Int,
    private val numberGenerator: NumberGenerator,
) {
    private val cars: Cars = Cars.makeNewCars(inputCarSize)
    private var round = Round(inputRoundCount)

    fun play() {
        round = round.decrease()
        cars.move(numberGenerator)
    }

    fun isEnd(): Boolean {
        return round.isZero()
    }

    fun extractCarInfos(): List<Int> {
        return cars.getPositionValues()
    }
}
