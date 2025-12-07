package solutions.y2025.d07

import cc.hubisoft.solutions.y2025.d07.Laboratories
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import readTestFile

class LaboratoriesTest {

    private val input = readTestFile(2025, "day07")

    @Test
    fun `solves part I`() {
        val laboratories = Laboratories(input)

        assertThat(laboratories.solvePartI()).isEqualTo(21)
    }

    @Test
    fun `solves part II`() {
        val laboratories = Laboratories(input)

        assertThat(laboratories.solvePartII()).isEqualTo(40)
    }
}