package racingcar

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : StringSpec({
    "시도 횟수 (Round) 만큼 각 자동차의 전진 / 멈춤 행위를 진행시킬 수 있다." {
        val racingGame = RacingGame(3, 2, RandomNumberGenerator())
        racingGame.play()
        racingGame.play()

        racingGame.isEnd() shouldBe true
        shouldThrowExactly<IllegalArgumentException> {
            racingGame.play()
        }
    }

    "게임의 상황를 확인할 수 있다." {
        val racingGame =
            RacingGame(
                3,
                2,
                CustomNumberGenerator(mutableListOf(4, 0, 0, 7, 6, 1)),
            )

        racingGame.play()
        racingGame.extractCarInfos() shouldBe listOf(1, 0, 0)

        racingGame.play()
        racingGame.extractCarInfos() shouldBe listOf(2, 1, 0)
    }
})
