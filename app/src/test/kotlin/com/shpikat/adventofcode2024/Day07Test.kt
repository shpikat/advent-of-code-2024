package com.shpikat.adventofcode2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Named
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day07Test {
    companion object {
        private val clazz = Day07::class.java

        private const val SAMPLE = """
190: 10 19
3267: 81 40 27
83: 17 5
156: 15 6
7290: 6 8 6 15
161011: 16 10 13
192: 17 8 14
21037: 9 7 18 13
292: 11 6 16 20
"""

        private const val ANSWER_PART1_SAMPLE = "3749"
        private const val ANSWER_PART1_PUZZLE = "3351424677624"
        private const val ANSWER_PART2_SAMPLE = "11387"
        private const val ANSWER_PART2_PUZZLE = "204976636995111"

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
