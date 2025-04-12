package com.testdex.utils

val String.Companion.empty: String get() = ""

fun String.replaceGenderSymbols(): String = this
    .replaceSuffix("-m", "♂")
    .replaceSuffix("-f", "♀")

fun String.toTitleCaseWithoutHyphen(): String = this
    .replace("-", " ")
    .split(" ")
    .joinToString(" ") { word ->
        word.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }

private fun String.replaceSuffix(suffix: String, replacement: String): String {
    return if (this.endsWith(suffix)) {
        this.removeSuffix(suffix) + replacement
    } else {
        this
    }
}