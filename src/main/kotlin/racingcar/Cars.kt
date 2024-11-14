package racingcar

class Cars(private val cars: List<Car>) {
    fun move(numberGenerator: NumberGenerator): Cars {
        return Cars(
            cars.map { _ ->
                return Cars(
                    cars.map { car ->
                        car.takeIf { moveCondition(numberGenerator) }?.move() ?: car
                    },
                )
            },
        )
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
