package com.shpikat.adventofcode2024

class Day03 {

    fun solvePart1(input: String): String {
        val regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)".toRegex()
        val answer = input
            .let { regex.findAll(it) }
            .map { it.destructured }
            .sumOf { (a, b) -> a.toUInt() * b.toUInt() }
        return answer.toString()
    }

    fun solvePart2(input: String): String {
        val regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)|don't\\(\\)|do\\(\\)".toRegex()
        val answer = input
            .let { regex.findAll(it) }
            .filter(enabled())
            .map { it.destructured }
            .sumOf { (a, b) -> a.toUInt() * b.toUInt() }
        return answer.toString()
    }

    @Suppress("AssignedValueIsNeverRead")
    private fun enabled(): (MatchResult) -> Boolean {
        // capturing local variable to improve readability on account of pureness (i.e. folding)
        var isEnabled = true
        return {
            if (it.groupValues[0] == "don't()") {
                isEnabled = false
                false
            } else if (it.groupValues[0] == "do()") {
                isEnabled = true
                false
            } else {
                isEnabled
            }
        }
    }
}
