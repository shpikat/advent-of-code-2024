package com.shpikat.adventofcode2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Named
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day02Test {
    companion object {
        private val clazz = Day02::class.java

        private const val SAMPLE = """
7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9
"""

        private const val ANSWER_PART1_SAMPLE = "2"
        private const val ANSWER_PART1_PUZZLE = "326"
        private const val ANSWER_PART2_SAMPLE = "4"
        private const val ANSWER_PART2_PUZZLE = "381"

        @JvmStatic
        fun testDataForPart1() = listOf(
            Arguments.of(Named.named("sample", SAMPLE.trim()), ANSWER_PART1_SAMPLE),
            Arguments.of(Named.named("puzzle input", readPuzzleInput(clazz)), ANSWER_PART1_PUZZLE),
        )

        @JvmStatic
        fun testDataForPart2() = listOf(
            Arguments.of(Named.named("sample", SAMPLE.trim()), ANSWER_PART2_SAMPLE),
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
