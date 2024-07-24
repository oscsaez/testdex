package com.testdex.ui.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.testdex.ui.navigation.TestdexScreen
import com.testdex.ui.theme.Dark
import com.testdex.ui.theme.Light
import com.testdex.ui.utils.roundedTopBordersShape

@Composable
fun TestdexBottomBar(
    modifier: Modifier = Modifier,
    elements: List<TestdexScreen>,
    onElementClick: (TestdexScreen) -> Unit
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar(
        modifier = modifier.clip(roundedTopBordersShape()),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.Transparent
    ) {
        elements.forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    onElementClick(screen)
                    selectedIndex = index
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.resIdIcon),
                        contentDescription = "${stringResource(id = screen.resIdName)} icon"
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primary,
                    selectedIconColor = Dark,
                    unselectedIconColor = Light
                )
            )
        }
    }
}