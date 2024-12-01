package com.shpikat.adventofcode2024

import java.io.IOException
import java.nio.charset.StandardCharsets
import java.util.*

@Throws(IOException::class)
fun readInput(filename: String): String {
    return String(
        requireNotNull(object {}.javaClass.getResourceAsStream("/$filename")).readAllBytes(),
        StandardCharsets.ISO_8859_1
    ).trimEnd()
}
