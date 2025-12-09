package solutions.y2025.d08

import cc.hubisoft.solutions.y2025.d08.Playground
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import readTestFile

class PlaygroundTest {

    private val input = readTestFile(2025, "day08")

    @Test
    fun `solves part I`() {
        val playground = Playground(input, 10)

        assertThat(playground.solvePartI()).isEqualTo(40)
    }

    @Test
    fun `solves part II`() {
        val playground = Playground(input, 10)

        assertThat(playground.solvePartII()).isEqualTo(25272L)
    }
}