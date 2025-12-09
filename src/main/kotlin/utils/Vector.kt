package cc.hubisoft.utils

import kotlin.math.pow
import kotlin.math.sqrt

sealed interface Vector<T : Number> {
    val x: T
    val y: T
}

data class IntVector(override val x: Int, override val y: Int) : Vector<Int> {
    operator fun plus(other: IntVector) = IntVector(x + other.x, y + other.y)
}

sealed interface Vector3<T : Number> {
    val x: T
    val y: T
    val z: T
}

data class IntVector3(override val x: Int, override val y: Int, override val z: Int) : Vector3<Int> {
    operator fun plus(other: IntVector3) = IntVector3(x + other.x, y + other.y, z + other.z)
    operator fun minus(other: IntVector3) = IntVector3(x - other.x, y - other.y, z - other.z)

    fun length() = sqrt(x.toDouble().pow(2) + y.toDouble().pow(2) + z.toDouble().pow(2))
}