package com.testdex.ui.screens.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.testdex.R

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    progress: Float
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.app_logo_size))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.rounded_border))),
                painter = painterResource(id = R.drawable.poke_tactics_logo),
                contentDescription = stringResource(id = R.string.app_logo_content_description))
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.screen_padding)))
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(dimensionResource(id = R.dimen.linear_progress_indicator_height))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.rounded_border))),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.secondary,
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.regular_padding)))
            Text(
                text = "${(progress * 100).toInt()} %",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}