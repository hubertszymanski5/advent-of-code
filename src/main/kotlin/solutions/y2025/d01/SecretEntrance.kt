package cc.hubisoft.solutions.y2025.d01

import cc.hubisoft.runner.DaySolution
import cc.hubisoft.solutions.y2025.d01.Direction.Companion.direction
import kotlin.math.abs

data class SecretEntrance(private val input: List<String>): DaySolution {

    private var count: Int = 50
    private var code = 0
    private val commands = mapInput()

    override fun solvePartI(): Int {
        count = 50
        code = 0
        commands.forEach { command ->
            when (command.direction) {
                Direction.LEFT -> turnLeft(command.num)
                Direction.RIGHT -> turnRight(command.num)
            }
            if (count == 0) code++
        }
        return code
    }

    override fun solvePartII(): Int {
        count = 50
        code = 0
        commands.forEach { command ->
            when (command.direction) {
                Direction.LEFT -> turnLeftWithClicks(command.num)
                Direction.RIGHT -> turnRightWithClicks(command.num)
            }
        }
        return code
    }

    private fun mapInput(): List<Command> =
        input.map { line ->
            val (direction, num) = COMMAND_REGEX.find(line)!!.destructured
            Command(direction(direction), num.toInt())
        }

    private fun turnLeft(num: Int) {
        val x = (count - num) % MAX_NUM
        count = if (x < 0) x + MAX_NUM else x
    }

    private fun turnRight(num: Int) {
        count = (count + num) % MAX_NUM
    }

    private fun turnLeftWithClicks(num: Int) {
        invert()
        turnRightWithClicks(num)
        invert()
    }

    private fun turnRightWithClicks(num: Int) {
        val diff = count + num
        code += diff / MAX_NUM
        count = diff % MAX_NUM
    }

    private fun invert() {
        count = abs(MAX_NUM - count) % MAX_NUM
    }

    companion object {
        private const val MAX_NUM = 100
        private val COMMAND_REGEX = """([LR])(\d+)""".toRegex()
    }
}
