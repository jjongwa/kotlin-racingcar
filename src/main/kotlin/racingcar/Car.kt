package racingcar

class Car(private val position: CarPosition) {
    fun move(): Car {
        return Car(position.advance())
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
