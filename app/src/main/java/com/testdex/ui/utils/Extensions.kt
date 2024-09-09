package com.testdex.ui.utils

import androidx.compose.foundation.lazy.LazyListState
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

fun NavHostController.navigateWithoutStack(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }

        launchSingleTop = true
        restoreState = true
    }
}

val String.Companion.empty: String get() = ""

fun String.replaceGenderSymbols(): String = this
    .replace("-m", "♂")
    .replace("-f", "♀")

internal fun LazyListState.reachedBottom(buffer: Int = 1): Boolean {
    val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull()
    return lastVisibleItem?.index != 0 && lastVisibleItem?.index == this.layoutInfo.totalItemsCount - buffer
}