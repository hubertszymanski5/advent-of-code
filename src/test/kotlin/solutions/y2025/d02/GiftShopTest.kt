package solutions.y2025.d02

import cc.hubisoft.solutions.y2025.d02.GiftShop
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import readTestFile

class GiftShopTest {

    private val input = readTestFile(2025, "day02")

    @Test
    fun `solves part I`() {
        val giftShop = GiftShop(input.joinToString(""))

        assertThat(giftShop.solvePartI()).isEqualTo(1227775554L)
    }

    @Test
    fun `solves part II`() {
        val giftShop = GiftShop(input.joinToString(""))

        assertThat(giftShop.solvePartII()).isEqualTo(4174379265L)
    }
}