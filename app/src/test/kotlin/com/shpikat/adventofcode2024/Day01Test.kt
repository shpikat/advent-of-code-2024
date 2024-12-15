package com.shpikat.adventofcode2024

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Named
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day01Test {
    companion object {
        private val clazz = Day01::class.java

        private const val SAMPLE = """
3   4
4   3
2   5
1   3
3   9
3   3
"""

        private const val ANSWER_PART1_SAMPLE = "11"
        private const val ANSWER_PART1_PUZZLE = "3574690"
        private const val ANSWER_PART2_SAMPLE = "31"
        private const val ANSWER_PART2_PUZZLE = "22565391"

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

    @ParameterizedTest()
    @MethodSource("testDataForPart1")
    fun testPart1(input: String, expected: String) {
        assertEquals(expected, day.solvePart1(input))
    }

    @ParameterizedTest
    @MethodSource("testDataForPart2")
    fun testPart2(input: String, expected: String) {
        assertEquals(expected, day.solvePart2(input))
    }
}
