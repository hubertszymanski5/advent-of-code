package cc.hubisoft.solutions.y2025.d09

import cc.hubisoft.utils.IntVector

data class Rectangle(val left: Int, val right: Int, val top: Int, val bottom: Int) {

    fun area() = (right - left + 1).toLong() * (top - bottom + 1).toLong()

    fun intersects(lines: List<Pair<IntVector, IntVector>>) =
        lines.any { collides(rectangle(it.first, it.second)) }

    fun collides(edge: Rectangle) =
        !(edge.left >= right || edge.right <= left || edge.top <= bottom || edge.bottom >= top)

    companion object {
        fun rectangle(p1: IntVector, p2: IntVector) = Rectangle(
            left = minOf(p1.x, p2.x),
            right = maxOf(p1.x, p2.x),
            top = maxOf(p1.y, p2.y),
            bottom = minOf(p1.y, p2.y)
        )
    }
}