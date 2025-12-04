package cc.hubisoft.utils

sealed interface Vector<T : Number> {
    val x: T
    val y: T
}

data class IntVector(override val x: Int, override val y: Int) : Vector<Int> {
    operator fun plus(other: IntVector) = IntVector(x + other.x, y + other.y)
}
