package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarsTest : StringSpec({
    "여러 대의 자동차를 가질 수 있다." {
        Cars(listOf(Car(CarPosition(0)), Car(CarPosition(0)), Car(CarPosition(0))))
    }

    "각 자동차의 전진 여부를 결정할 수 있다." {
        forAll(
            row(0, 0, 0, 0),
            row(0, 4, 0, 1),
            row(9, 3, 1, 0),
            row(4, 8, 1, 1),
        ) { valueA, valueB, afterA, afterB ->
            val cars =
                Cars(
                    listOf(
                        Car(CarPosition(0)),
                        Car(CarPosition(0)),
                    ),
                )
            cars.move(CustomNumberGenerator(mutableListOf(valueA, valueB)))
            cars.getPositionValues() shouldBe listOf(afterA, afterB)
        }
    }

    "각 자동차의 위치를 외부에 전달할 수 있다." {
        val cars =
            Cars(
                listOf(
                    Car(CarPosition(0)),
                    Car(CarPosition(1)),
                    Car(CarPosition(2)),
                ),
            )
        cars.getPositionValues() shouldBe listOf(0, 1, 2)
    }
})
