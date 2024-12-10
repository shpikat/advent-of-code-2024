package com.shpikat.adventofcode2024

class Day04 {

    fun solvePart1(input: String): String {
        val lines = input
            .split("\n")

        val directions: List<(Point) -> Point> = listOf(
            { p -> Point(p.x - 1, p.y - 1) },
            { p -> Point(p.x, p.y - 1) },
            { p -> Point(p.x + 1, p.y - 1) },
            { p -> Point(p.x - 1, p.y) },
            { p -> Point(p.x, p.y) },
            { p -> Point(p.x + 1, p.y) },
            { p -> Point(p.x - 1, p.y + 1) },
            { p -> Point(p.x, p.y + 1) },
            { p -> Point(p.x + 1, p.y + 1) },
        )

        val answer = lines
            .flatMapIndexed { y, line ->
                line.mapIndexed { x, ch ->
                    if (ch == 'X') {
                        directions.count { next ->
                            generateSequence(next(Point(x, y))) { next(it) }
                                .map { it.takeFrom(lines) }
                                .zip("MAS".asSequence()) { a, b -> a == b }
                                .all { it }
                        }
                    } else {
                        0
                    }
                }
            }
            .sum()

        return answer.toString()
    }

    fun solvePart2(input: String): String {
        val lines = input
            .split("\n")

        val positions: List<(Point) -> Collection<Point>> = listOf(
            { p ->
                listOf(
                    Point(p.x - 1, p.y - 1),
                    Point(p.x + 1, p.y + 1),
                )
            },
            { p ->
                listOf(
                    Point(p.x + 1, p.y - 1),
                    Point(p.x - 1, p.y + 1),
                )
            },
        )

        val answer = lines
            .flatMapIndexed { y, line ->
                line.mapIndexed { x, ch ->
                    ch == 'A' && positions.all { around ->
                        around(Point(x, y))
                            .map { it.takeFrom(lines) }
                            .containsAll(listOf('M', 'S'))
                    }
                }
            }
            .count { it }

        return answer.toString()
    }

    private data class Point(val x: Int, val y: Int) {
        fun takeFrom(lines: List<String>) = if (y in (0..<lines.size) && x in (0..<lines[y].length)) {
            lines[y][x]
        } else {
            null
        }
    }
}
