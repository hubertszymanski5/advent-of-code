package solutions.y2025.day05

import cc.hubisoft.solutions.y2025.day05.Cafeteria
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import readTestFile

class CafeteriaTest {

    private val input = readTestFile(2025, "day05")

    @Test
    fun `passes part I`() {
        val cafeteria = Cafeteria(input)

        assertThat(cafeteria.solvePartI()).isEqualTo(3)
    }

    @Test
    fun `passes part II`() {
        val cafeteria = Cafeteria(input)

        assertThat(cafeteria.solvePartII()).isEqualTo(14)
    }
}