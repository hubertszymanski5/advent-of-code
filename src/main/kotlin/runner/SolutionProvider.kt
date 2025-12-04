package cc.hubisoft.runner

import cc.hubisoft.solutions.y2025.provider.Year2025Provider

object SolutionProvider {

    private val daySolutionProviders = mapOf(
        2025 to Year2025Provider
    )

    fun findDay(year: Int, day: Int): DaySolution? {
        return daySolutionProviders[year]?.findDay(day)
    }
}