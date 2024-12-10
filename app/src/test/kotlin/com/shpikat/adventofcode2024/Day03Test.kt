package com.shpikat.adventofcode2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Named
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day03Test {
    companion object {
        private val clazz = Day03::class.java

        private const val SAMPLE1 = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        private const val SAMPLE2 = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

        private const val ANSWER_PART1_SAMPLE = "161"
        private const val ANSWER_PART1_PUZZLE = "173419328"
        private const val ANSWER_PART2_SAMPLE = "48"
        private const val ANSWER_PART2_PUZZLE = "90669332"

        @JvmStatic
        fun testDataForPart1() = listOf(
            Arguments.of(Named.named("sample 1", SAMPLE1.trim()), ANSWER_PART1_SAMPLE),
            Arguments.of(Named.named("puzzle input", readPuzzleInput(clazz)), ANSWER_PART1_PUZZLE),
        )

        @JvmStatic
        fun testDataForPart2() = listOf(
            Arguments.of(Named.named("sample 2", SAMPLE2.trim()), ANSWER_PART2_SAMPLE),
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
