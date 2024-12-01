package com.shpikat.adventofcode2024

import kotlin.math.abs

class Day01 {
    private val regex = "(\\d+)\\s+(\\d+)".toRegex()

    fun solvePart1(input: String): String {
        val (first, second) = input
            .split("\n")
            .map { requireNotNull(regex.matchEntire(it)).destructured }
            .map { (first, second) -> Integer.parseInt(first) to Integer.parseInt(second) }
            .unzip()
        val answer = first
            .sorted()
            .zip(second.sorted())
            .sumOf { abs(it.first - it.second) }
        return answer.toString()
    }

    fun solvePart2(input: String): String {
        val (first, second) = input
            .split("\n")
            .map { requireNotNull(regex.matchEntire(it)).destructured }
            .map { (first, second) -> Integer.parseInt(first) to Integer.parseInt(second) }
            .unzip()
        val counts = second.groupingBy { it }.eachCount()
        val answer = first.sumOf { it * counts.getOrDefault(it, 0) }
        return answer.toString()
    }
}
