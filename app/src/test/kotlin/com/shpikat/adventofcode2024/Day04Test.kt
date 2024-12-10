package com.shpikat.adventofcode2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Named
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day04Test {
    companion object {
        private val clazz = Day04::class.java

        private const val SAMPLE = """
MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MSAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX
"""

        private const val ANSWER_PART1_SAMPLE = "18"
        private const val ANSWER_PART1_PUZZLE = "2569"
        private const val ANSWER_PART2_SAMPLE = "9"
        private const val ANSWER_PART2_PUZZLE = "1998"

        @JvmStatic
        fun testDataForPart1() = listOf(
            Arguments.of(Named.named("sample 1", SAMPLE.trim()), ANSWER_PART1_SAMPLE),
            Arguments.of(Named.named("puzzle input", readPuzzleInput(clazz)), ANSWER_PART1_PUZZLE),
        )

        @JvmStatic
        fun testDataForPart2() = listOf(
            Arguments.of(Named.named("sample 2", SAMPLE.trim()), ANSWER_PART2_SAMPLE),
            Arguments.of(Named.named("puzzle input", readPuzzleInput(clazz)), ANSWER_PART2_PUZZLE),
        )
    }

    private val day = clazz.getDeclaredConstructor().newInstance()

    @ParameterizedTest
    @MethodSource("testDataForPart1")
    fun testPart1(input: String, expected: String) {
        Assertions.assertEquals(expected, day.solvePart1(input))
    }

    @ParameterizedTest
    @MethodSource("testDataForPart2")
    fun testPart2(input: String, expected: String) {
        Assertions.assertEquals(expected, day.solvePart2(input))
    }
}
