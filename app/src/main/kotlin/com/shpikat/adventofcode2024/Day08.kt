package com.shpikat.adventofcode2024

private const val EMPTY = '.'

class Day08 {

    fun solvePart1(input: String): String {
        val lines = input.split("\n")

        val height = lines.size
        val width = lines.first().length

        val answer = lines
            .asSequence()
            .flatMapIndexed { y, line ->
                line
                    .asSequence()
                    .mapIndexed { x, ch -> ch to Position(x, y) }
            }
            .filter { it.first != EMPTY }
            .groupBy({ it.first }, { it.second })
            .values
            .asSequence()
            .flatMap { it.getAllPairs() }
            .flatMap { (a, b) ->
                listOf(
                    Position(a.x - (b.x - a.x), a.y - (b.y - a.y)),
                    Position(b.x + (b.x - a.x), b.y + (b.y - a.y)),
                )
                    .filter { it.x in (0..<width) && it.y in (0..<height) }
            }
            .distinct()
            .count()

        return answer.toString()
    }

    fun solvePart2(input: String): String {
        val lines = input.split("\n")

        val height = lines.size
        val width = lines.first().length

        val answer = lines
            .asSequence()
            .flatMapIndexed { y, line ->
                line
                    .asSequence()
                    .mapIndexed { x, ch -> ch to Position(x, y) }
            }
            .filter { it.first != EMPTY }
            .groupBy({ it.first }, { it.second })
            .values
            .asSequence()
            .flatMap { it.getAllPairs() }
            .flatMap { (a, b) ->
                val dx = b.x - a.x
                val dy = b.y - a.y
                sequenceOf(
                    generateSequence(Position(a.x, a.y)) { Position(it.x - dx, it.y - dy) },
                    generateSequence(Position(b.x, b.y)) { Position(it.x + dx, it.y + dy) },
                )
                    .flatMap { sequence -> sequence.takeWhile { it.x in (0..<width) && it.y in (0..<height) } }
            }
            .distinct()
            .count()

        return answer.toString()
    }

    private data class Position(val x: Int, val y: Int)

    private fun <T> List<T>.getAllPairs(): Sequence<Pair<T, T>> = sequence {
        for (i in 0 until size - 1) {
            for (j in i + 1 until size) {
                yield(get(i) to get(j))
            }
        }
    }
}
