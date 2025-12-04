package solutions.y2025.d04

import cc.hubisoft.solutions.y2025.d04.PrintingDepartment
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import readTestFile

class PrintingDepartmentTest {

    private val input = readTestFile(2025, "day04")

    @Test
    fun `solves part I`() {
        val printingDepartment = PrintingDepartment(input)

        assertThat(printingDepartment.solvePartI()).isEqualTo(13)
    }

    @Test
    fun `solves part II`() {
        val printingDepartment = PrintingDepartment(input)

        assertThat(printingDepartment.solvePartII()).isEqualTo(43)
    }
}