package com.shpikat.adventofcode2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Named
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day05Test {
    companion object {
        private val clazz = Day05::class.java

        private const val SAMPLE = """
47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

75,47,61,53,29
97,61,53,29,13
75,29,13
75,97,47,61,53
61,13,29
97,13,75,29,47
"""

        private const val ANSWER_PART1_SAMPLE = "143"
        private const val ANSWER_PART1_PUZZLE = "5091"
        private const val ANSWER_PART2_SAMPLE = "123"
        private const val ANSWER_PART2_PUZZLE = "4681"

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
