package solutions.y2025.d06

import cc.hubisoft.solutions.y2025.d06.TrashCompactor
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import readTestFile

class TrashCompactorTest {

    private val input = readTestFile(2025, "day06")

    @Test
    fun `solves part I`() {
        val trashCompactor = TrashCompactor(input)

        assertThat(trashCompactor.solvePartI()).isEqualTo(4277556)
    }

    @Test
    fun `solves part II`() {
        val trashCompactor = TrashCompactor(input)

        assertThat(trashCompactor.solvePartII()).isEqualTo(3263827)
    }
}