package com.shpikat.adventofcode2024

class Day05 {

    fun solvePart1(input: String): String {
        val (rules, updates) = input
            .split("\n\n", limit = 2)

        val ordering = parseRules(rules)

        val answer = updates
            .split("\n")
            .map { parseUpdate(it) }
            .filter { isUpdateCorrect(it, ordering) }
            .sumOf { it[it.size / 2] }

        return answer.toString()
    }

    fun solvePart2(input: String): String {
        val (rules, updates) = input
            .split("\n\n", limit = 2)

        val ordering = parseRules(rules)
            .mapValues { it.value.toSet() }

        val answer = updates
            .split("\n")
            .map { parseUpdate(it) }
            .filterNot { isUpdateCorrect(it, ordering) }
            .map {
                it.sortedWith { a, b ->
                    when {
                        ordering[a]?.contains(b) == true -> -1
                        ordering[b]?.contains(a) == true -> 1
                        else -> 0
                    }
                }
            }
            .sumOf { it[it.size / 2] }

        return answer.toString()
    }

    private fun parseRules(rules: String): Map<Int, List<Int>> =
        rules
            .split("\n")
            .map {
                val (first, second) = it
                    .split('|', limit = 2)
                    .map(Integer::parseInt)
                first to second
            }
            .groupBy({ it.first }) { it.second }

    private fun parseUpdate(string: String): List<Int> = string
        .split(',')
        .map(Integer::parseInt)

    private fun isUpdateCorrect(update: List<Int>, ordering: Map<Int, Collection<Int>>): Boolean =
        update
            .fold(true to hashSetOf<Int>()) { acc, page ->
                if (acc.first) {
                    val isCorrect = ordering
                        .getOrDefault(page, emptyList())
                        .none { it in acc.second }
                    acc.second.add(page)
                    isCorrect to acc.second
                } else {
                    acc
                }
            }
            .first
}
