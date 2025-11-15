package com.shpikat.adventofcode2024

class Day07 {

    fun solvePart1(input: String): String {
        val lines = input.split("\n")

        /* Multiplication grows faster, so it's applied before addition */
        val answer = lines
            .map { it.split(": ", limit = 2) }
            .map { (sum, equation) -> sum.toLong() to equation.split(' ').map { it.toLong() } }
            .filter {
                isSolvable(
                    sum = it.first,
                    operations = listOf(
                        ::multiply,
                        ::add,
                    ),
                    current = 0,
                    equation = it.second
                )
            }
            .sumOf { it.first }
        return answer.toString()
    }

    fun solvePart2(input: String): String {
        val lines = input.split("\n")

        /* Concatenation can grow even faster, placing it first */
        val answer = lines
            .map { it.split(": ", limit = 2) }
            .map { (sum, equation) -> sum.toLong() to equation.split(' ').map { it.toLong() } }
            .filter {
                isSolvable(
                    sum = it.first,
                    operations = listOf(
                        ::concatenate,
                        ::multiply,
                        ::add,
                    ),
                    current = 0,
                    equation = it.second
                )
            }
            .sumOf { it.first }
        return answer.toString()
    }

    private fun isSolvable(
        sum: Long,
        operations: Collection<(Long, Long) -> Long>,
        current: Long,
        equation: List<Long>,
    ): Boolean {
        if (current > sum) {
            return false
        }
        if (equation.isEmpty()) {
            return current == sum
        }
        val next = equation.first()
        val restOfEquation = equation.subList(1, equation.size)
        return operations.any { isSolvable(sum, operations, it(current, next), restOfEquation) }
    }

    companion object {
        private fun multiply(a: Long, b: Long): Long = a * b
        private fun add(a: Long, b: Long): Long = a + b
        private fun concatenate(a: Long, b: Long): Long {
            var powerOfTen = 0
            var temp = b
            while (temp != 0L) {
                powerOfTen += 1
                temp /= 10
            }
            return a * powersOfTen[powerOfTen] + b
        }

        private val powersOfTen = generateSequence(1L) { it * 10 }.take(20).toList()
    }
}
