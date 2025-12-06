package cc.hubisoft.solutions.y2025.provider

import cc.hubisoft.runner.DaySolutionProvider
import cc.hubisoft.solutions.y2025.d01.SecretEntrance
import cc.hubisoft.solutions.y2025.d02.GiftShop
import cc.hubisoft.solutions.y2025.d03.Lobby
import cc.hubisoft.solutions.y2025.d04.PrintingDepartment
import cc.hubisoft.solutions.y2025.d06.TrashCompactor
import cc.hubisoft.solutions.y2025.day05.Cafeteria
import cc.hubisoft.utils.readFile

object Year2025Provider : DaySolutionProvider {

    private const val YEAR = 2025

    private val days = mapOf(
        1 to { SecretEntrance(readFile(YEAR, "day01")) },
        2 to { GiftShop(readFile(YEAR, "day02").joinToString("")) },
        3 to { Lobby(readFile(YEAR, "day03")) },
        4 to { PrintingDepartment(readFile(YEAR, "day04")) },
        5 to { Cafeteria(readFile(YEAR, "day05")) },
        6 to { TrashCompactor(readFile(YEAR, "day06")) }
    )

    override fun findDay(day: Int) = days[day]?.invoke()
}