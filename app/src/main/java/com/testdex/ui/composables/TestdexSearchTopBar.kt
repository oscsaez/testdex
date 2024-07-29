package com.testdex.ui.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.testdex.ui.utils.empty
import com.testdex.ui.utils.roundedBottomBordersShape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestdexSearchTopBar(
    modifier: Modifier = Modifier,
    rightActions: @Composable (RowScope.() -> Unit),
    onAppIconButtonClick: () -> Unit,
    onSearch: (String) -> Unit
) {
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
                    .padding(dimensionResource(id = R.dimen.regular_padding)),
                value = input,
                onValueChange = { input = it },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.search_top_bar_text),
                        style = MaterialTheme.typography.bodyLarge
                    )
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
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = MaterialTheme.colorScheme.background,
                    textColor = MaterialTheme.colorScheme.onBackground,
                    disabledTextColor = MaterialTheme.colorScheme.onBackground
                    // TODO
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = { onSearch(input) }
                )
            )
        },
        actions = rightActions,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}