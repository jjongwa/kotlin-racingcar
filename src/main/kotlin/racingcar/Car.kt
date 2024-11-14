package racingcar

class Car(private var position: CarPosition) {
    fun move() {
        position = position.advance()
    }

    fun getPositionValue(): Int {
        return position.value
    }

    companion object {
        fun makeNewCar(): Car {
            return Car(CarPosition.startPosition())
        }
    }
}
