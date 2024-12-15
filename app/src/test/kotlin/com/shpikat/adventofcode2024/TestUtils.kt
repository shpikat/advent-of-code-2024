package com.shpikat.adventofcode2024

import java.io.IOException
import java.nio.charset.StandardCharsets
import java.util.*

@Throws(IOException::class)
fun readPuzzleInput(clazz: Class<out Any>): String = readFileAsLatin1String(clazz.simpleName.lowercase() + "_input.txt")

@Throws(IOException::class)
fun readFileAsLatin1String(filename: String): String =
    String(
        requireNotNull(object {}.javaClass.getResourceAsStream("/$filename")).readAllBytes(),
        StandardCharsets.ISO_8859_1
    ).trimEnd()
