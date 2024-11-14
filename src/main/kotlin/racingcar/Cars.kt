package racingcar

class Cars(private val cars: List<Car>) {
    fun move(numberGenerator: NumberGenerator) {
        cars.filter { moveCondition(numberGenerator) }
            .forEach { it.move() }
    }

    private fun moveCondition(numberGenerator: NumberGenerator): Boolean {
        return numberGenerator.generateWithValidation() >= 4
    }

    fun getPositionValues(): List<Int> {
        return cars.map { it.getPositionValue() }
    }

    companion object {
        fun makeNewCars(count: Int): Cars {
            return Cars((0 until count).map { Car.makeNewCar() })
        }
    }
}
