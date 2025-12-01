package y2025.d01

import cc.hubisoft.y2025.d01.SecretEntrance
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import readFile

class SecretEntranceTest {

    private val input = readFile(2025, "day01")

    @Test
    fun `solves part I`() {
        val secretEntrance = SecretEntrance(input)

        assertThat(secretEntrance.solvePartI()).isEqualTo(3)
    }

    @Test
    fun `solves part II`() {
        val secretEntrance = SecretEntrance(input)
        assertThat(secretEntrance.solvePartII()).isEqualTo(6)
    }

    @ParameterizedTest(name = "turns right {0} times")
    @CsvSource(
        "49, 0",
        "50, 1",
        "149, 1",
        "150, 2",
        "200, 2",
        "249, 2",
        "250, 3",
        "500, 5")
    fun `handles spinning right`(clicks: Int, expected: Int) {
        val secretEntrance = SecretEntrance(listOf("R$clicks"))
        assertThat(secretEntrance.solvePartII()).isEqualTo(expected)
    }

    @ParameterizedTest(name = "turns left {0} times")
    @CsvSource(
        "49, 0",
        "50, 1",
        "149, 1",
        "150, 2",
        "200, 2",
        "249, 2",
        "250, 3",
        "500, 5")
    fun `handles spinning left`(clicks: Int, expected: Int) {
        val secretEntrance = SecretEntrance(listOf("L$clicks"))
        assertThat(secretEntrance.solvePartII()).isEqualTo(expected)
    }

    @ParameterizedTest(name = "turns left {0} times")
    @CsvSource(
        "99, 1",
        "100, 2",
        "199, 2",
        "200, 3",
        "299, 3",
        "300, 4",
        "399, 4",
        "400, 5")
    fun `handles following zeros going right`(clicks: Int, expected: Int) {
        val secretEntrance = SecretEntrance(listOf("R50", "R$clicks"))
        assertThat(secretEntrance.solvePartII()).isEqualTo(expected)
    }

    @ParameterizedTest(name = "turns left {0} times")
    @CsvSource(
        "99, 1",
        "100, 2",
        "199, 2",
        "200, 3",
        "299, 3",
        "300, 4",
        "399, 4",
        "400, 5")
    fun `handles following zeros going left`(clicks: Int, expected: Int) {
        val secretEntrance = SecretEntrance(listOf("R50", "L$clicks"))
        assertThat(secretEntrance.solvePartII()).isEqualTo(expected)
    }
}