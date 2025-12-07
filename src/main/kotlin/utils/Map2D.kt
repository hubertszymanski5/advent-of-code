package cc.hubisoft.utils

class Map2D<T> {
    val xSize: Int
    val ySize: Int
    private val fields: HashMap<Pair<Int, Int>, T>

    constructor(input: List<List<T>>) {
        if (input.isEmpty()) throw IllegalArgumentException("Input must not be empty")
        ySize = input.size
        xSize = input[0].size
        val mappedFields = input.flatMapIndexed { y, row ->
            if (row.size != xSize) throw IllegalArgumentException("All rows must have the same size")
            row.mapIndexed { x, value -> Pair(x, y) to value }
        }.toMap()
        fields = HashMap(mappedFields)
    }

    private constructor(map2D: Map2D<T>) {
        xSize = map2D.xSize
        ySize = map2D.ySize
        fields = HashMap(map2D.fields)
    }

    fun get(x: Int, y: Int): T? = fields[x to y]

    fun get(p: Pair<Int, Int>): T? = fields[p]

    fun get(v: IntVector): T? = get(v.x, v.y)

    fun find(value: T) = fields.entries.find { it.value == value }?.key

    fun allCoordinates() = (0 until xSize).flatMap { x -> (0 until ySize).map { y -> IntVector(x, y) } }

    fun values() = fields.values

    fun columns() = (0 until xSize).map { x -> (0 until ySize).map { y -> get(x, y)!! } }

    fun replace(point: IntVector, newValue: T) {
        fields[point.x to point.y] = newValue
    }

    fun copy(): Map2D<T> = Map2D(this)

    override fun toString() =
        (0 until ySize).joinToString("\n") { y ->
            (0 until xSize).joinToString(" ") { x -> get(x, y).toString() }
        }
}