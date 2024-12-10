package com.shpikat.adventofcode2024

class Day02 {
    fun solvePart1(input: String): String {
        val answer = input
            .split("\n")
            .map { it.split(" ").map(Integer::parseInt) }
            .map { if (it.count() > 1 && it[0] > it[1]) it.reversed() else it }
            .map { it.asSequence().zipWithNext() }
            .count { it.all { (a, b) -> isSafe(b, a) } }
        return answer.toString()
    }

    fun solvePart2(input: String): String {
        val (safe, unsafe) = input
            .split("\n")
            .map { it.split(" ").map(Integer::parseInt) }
            .partition {
                val withNext = it.asSequence().zipWithNext()
                withNext.all { (a, b) -> isSafe(b, a) } || withNext.all { (a, b) -> isSafe(a, b) }
            }

        val quiteSafe = unsafe
            .count { report ->
                (0..<report.size)
                    .asSequence()
                    .map { report.subList(0, it) + report.subList(it + 1, report.size) }
                    .any {
                        val withNext = it.asSequence().zipWithNext()
                        withNext.all { (a, b) -> isSafe(b, a) } || withNext.all { (a, b) -> isSafe(a, b) }
                    }
            }

        val answer = safe.size + quiteSafe
        return answer.toString()
    }

    private fun isSafe(a: Int, b: Int): Boolean = a - b in (1..3)
}
