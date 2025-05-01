package com.testdex.ui.composables

import androidx.compose.foundation.BasicTooltipBox
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberBasicTooltipState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.testdex.R
import com.testdex.ui.utils.roundedBottomBordersShape
import com.testdex.utils.empty
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun TestdexSearchTopBar(
    modifier: Modifier = Modifier,
    rightActions: @Composable (RowScope.() -> Unit),
    onAppIconButtonClick: () -> Unit,
    onSearch: (String) -> Unit
) {
    val tooltipPosition = TooltipDefaults.rememberPlainTooltipPositionProvider()
    val tooltipState = rememberBasicTooltipState(isPersistent = false)
    val scope = rememberCoroutineScope()
    var input by remember { mutableStateOf(String.empty) }

    TopAppBar(
        modifier = modifier.clip(roundedBottomBordersShape()),
        navigationIcon = {
            IconButton(
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.regular_padding)),
                onClick = onAppIconButtonClick
            ) {
                Icon(
                    // TODO Real app icon
                    painter = painterResource(id = R.drawable.ic_pokeball),
                    contentDescription = "App icon",
                    tint = MaterialTheme.colorScheme.background
                )
            }
        },
        title = {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.search_text_field_padding)),
                value = input,
                onValueChange = {
                    input = it
                    onSearch(input)
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.search_top_bar_text),
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1
                    )
                },
                leadingIcon = {
                    BasicTooltipBox(
                        positionProvider = tooltipPosition,
                        tooltip = {
                            Box(
                                modifier = Modifier
                                    .padding(
                                        horizontal = dimensionResource(id = R.dimen.screen_padding),
                                        vertical = dimensionResource(id = R.dimen.less_regular_padding)
                                    )
                                    .background(
                                        color = MaterialTheme.colorScheme.onBackground,
                                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.rounded_border))
                                    )
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(dimensionResource(id = R.dimen.regular_padding)),
                                    text = stringResource(id = R.string.search_top_bar_tooltip_text),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.background
                                )
                            }
                        },
                        state = tooltipState
                    ) {
                        IconButton(
                            onClick = {
                                // TODO Change tooltip component to can set default timeout
                                scope.launch { tooltipState.show(MutatePriority.UserInput) }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Info,
                                contentDescription = "Help icon",
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }
                },
                trailingIcon = {
                    IconButton(
                        onClick = { onSearch(input) }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search icon",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                textStyle = MaterialTheme.typography.bodyLarge,
                shape = CircleShape,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    focusedTextColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
                    disabledTextColor = MaterialTheme.colorScheme.onBackground
                    // TODO Add more parameters if needed
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = { onSearch(input) }
                ),
                singleLine = true
            )
        },
        actions = rightActions,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}