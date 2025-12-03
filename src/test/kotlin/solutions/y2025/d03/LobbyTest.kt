package solutions.y2025.d03

import cc.hubisoft.solutions.y2025.d03.Lobby
import org.assertj.core.api.Assertions.assertThat
import readTestFile
import kotlin.test.Test

class LobbyTest {

    private val input = readTestFile(2025, "day03")

    @Test
    fun `solves part I`() {
        val lobby = Lobby(input)

        assertThat(lobby.solvePartI()).isEqualTo(357)
    }

    @Test
    fun `solves part II`() {
        val lobby = Lobby(input)

        assertThat(lobby.solvePartII()).isEqualTo(3121910778619L)
    }
}