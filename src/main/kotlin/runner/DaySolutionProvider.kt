package cc.hubisoft.runner

interface DaySolutionProvider {
    fun findDay(day: Int): DaySolution?
}