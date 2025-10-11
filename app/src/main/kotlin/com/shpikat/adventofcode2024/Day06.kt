package com.shpikat.adventofcode2024

private const val GUARD = '^'
private const val OBSTRUCTION = '#'

class Day06 {

    fun solvePart1(input: String): String {
        val lines = input.split("\n")

        val start = findStart(lines)
        val answer = generateSequence(start to Direction.UP) { (position, direction) ->
            moveOrNull(lines, position, direction)
        }
            .distinctBy { it.first }
            .count()

        return answer.toString()
    }

    fun solvePart2(input: String): String {
        val lines = input.split("\n")

        val start = findStart(lines)
        val answer = generateSequence(start to Direction.UP) { (position, direction) ->
            moveOrNull(lines, position, direction)
        }
            .map { it.first }
            .distinct()
            .drop(1)
            .map {
                val modified = lines[it.y].replaceRange(it.x, it.x + 1, OBSTRUCTION.toString())
                lines.subList(0, it.y) + listOf(modified) + lines.subList(it.y + 1, lines.size)
            }
            .count { modifiedLines ->
                generateSequence(start to Direction.UP) { (position, direction) ->
                    moveOrNull(modifiedLines, position, direction)
                }
                    .firstOrNull(hasVisited()) != null
            }
        return answer.toString()
    }

    private fun hasVisited(): (Pair<Position, Direction>) -> Boolean {
        // takes ages with immutable collections
        val visited = mutableSetOf<Pair<Position, Direction>>()
        return { !visited.add(it) }
    }

    private fun findStart(lines: List<String>): Position = lines
        .withIndex()
        .first { it.value.contains(GUARD) }
        .let { (index, line) -> Position(line.indexOf(GUARD), index) }

    private tailrec fun moveOrNull(
        lines: List<String>,
        position: Position,
        direction: Direction,
    ): Pair<Position, Direction>? {
        val next = direction.next(position)
        return if (!isWithin(lines, next)) {
            null
        } else if (isObstruction(lines, next)) {
            moveOrNull(lines, position, direction.turn()) // won't be infinite, there is always a way out
        } else {
            next to direction
        }
    }

    private fun isWithin(lines: List<String>, p: Position) = p.y in (0..<lines.size) && p.x in (0..<lines[p.y].length)

    private fun isObstruction(lines: List<String>, p: Position) = lines[p.y][p.x] == OBSTRUCTION

    private data class Position(val x: Int, val y: Int)

    private enum class Direction {
        UP {
            override fun next(p: Position): Position = Position(p.x, p.y - 1)
        },
        RIGHT {
            override fun next(p: Position): Position = Position(p.x + 1, p.y)
        },
        DOWN {
            override fun next(p: Position): Position = Position(p.x, p.y + 1)
        },
        LEFT {
            override fun next(p: Position): Position = Position(p.x - 1, p.y)
        };

        abstract fun next(p: Position): Position

        fun turn(): Direction = Direction.entries[(ordinal + 1) % Direction.entries.size]
    }
}
