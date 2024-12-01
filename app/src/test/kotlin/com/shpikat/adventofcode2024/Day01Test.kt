package com.shpikat.adventofcode2024

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Named.named
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

private const val sample: String = """
3   4
4   3
2   5
1   3
3   9
3   3
"""

private const val inputFilename: String = "day01_input.txt"
private const val part1SampleAnswer: String = "11"
private const val part1Answer: String = "3574690"
private const val part2SampleAnswer: String = "31"
private const val part2Answer: String = "22565391"

class Day01Test {
    private val day = Day01()

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

    companion object {
        @JvmStatic
        fun testDataForPart1() = listOf(
            Arguments.of(named("sample", sample.trim()), part1SampleAnswer),
            Arguments.of(named("puzzle input", readInput(inputFilename)), part1Answer),
        )

        @JvmStatic
        fun testDataForPart2() = listOf(
            Arguments.of(named("sample", sample.trim()), part2SampleAnswer),
            Arguments.of(named("puzzle input", readInput(inputFilename)), part2Answer),
        )
    }
}
