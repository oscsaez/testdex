package com.testdex.ui.composables

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.testdex.R

@Composable
fun NoNetworkConnectionDialog(
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.rounded_border)),
        onDismissRequest = { /*Do nothing*/ },
        confirmButton = { 
            Button(
                onClick = { /*Do nothing*/ }
            ) {
                Text(
                    text = stringResource(id = R.string.ok_text),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        title = {
            Text(
                text = stringResource(id = R.string.no_network_connection_title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        text = {
            Text(
                text = stringResource(id = R.string.no_network_connection_text),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    )
}