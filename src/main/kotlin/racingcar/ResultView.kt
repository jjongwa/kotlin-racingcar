package racingcar

class ResultView {
    fun printResultMessage() {
        println("실행 결과")
    }

    fun print(extractCarInfos: List<Int>) {
        for (carPosition in extractCarInfos) {
            println("-".repeat(carPosition))
        }
        println()
    }
}
