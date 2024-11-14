package racingcar

fun main() {
    val inputView = InputView()
    val inputCarSize = inputView.inputCarSize()
    val inputRoundCount = inputView.inputRoundCount()

    val game = RacingGame(inputCarSize, inputRoundCount, RandomNumberGenerator())

    val resultView = ResultView()
    resultView.printResultMessage()
    while (!game.isEnd()) {
        game.play()
        resultView.print(game.extractCarInfos())
    }
}
