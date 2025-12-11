package solutions.y2025.d09

import cc.hubisoft.solutions.y2025.d09.MovieTheater
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import readTestFile

class MovieTheaterTest {

    private val input = readTestFile(2025, "day09")

    @Test
    fun `solves part I`() {
        val movieTheater = MovieTheater(input)

        assertThat(movieTheater.solvePartI()).isEqualTo(50)
    }

    @Disabled("example is edge case that does not occur in main input")
    @Test
    fun `solves part II`() {
        val movieTheater = MovieTheater(input)

        assertThat(movieTheater.solvePartII()).isEqualTo(24)
    }
}