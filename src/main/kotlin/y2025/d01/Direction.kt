package cc.hubisoft.y2025.d01

enum class Direction {
    LEFT, RIGHT;

    companion object {
        fun direction(str: String) =
            when (str) {
                "L" -> LEFT
                "R" -> RIGHT
                else -> throw IllegalArgumentException("Invalid direction: $str")
            }
    }
}
