package cc.hubisoft.utils

enum class Direction(val dx: Int, val dy: Int) {
    N(0, -1),
    NE(1, -1),
    E(1, 0),
    SE(1, 1),
    S(0, 1),
    SW(-1, 1),
    W(-1, 0),
    NW(-1, -1);

    fun asVector() = IntVector(dx, dy)

    companion object {
        fun mainDirections() = setOf(N, E, S, W)
        fun allDirections() = entries.toSet()
    }
}