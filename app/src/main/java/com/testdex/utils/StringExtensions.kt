package com.testdex.utils

val String.Companion.empty: String get() = ""

fun String.replaceGenderSymbols(): String = this
    .replace("-m", "♂")
    .replace("-f", "♀")

fun String.toTitleCaseWithoutHyphen(): String = this
    .replace("-", " ")
    .replaceFirstChar { it.uppercase() }