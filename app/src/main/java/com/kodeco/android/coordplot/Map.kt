package com.kodeco.android.coordplot

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.Black
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {
    val config = LocalConfiguration.current
    val boxWidth = when (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        true -> 200
        false -> 300
    }
    val boxHeight = when (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        true -> 200
        false -> 300
    }
    val logoWidth = 45
    val logoHeight = 45
    val logoXCoord = (xPercent * (boxWidth - logoWidth))
    val logoYCoord = (yPercent * (boxHeight - logoHeight))

    Box {
        Box(
            modifier = Modifier
                .size(boxWidth.dp)
                .background(Black)
        )
        Image(painter = painterResource(id = R.drawable.kodeco_logo),
            contentDescription = "Kodeco Logo",
            modifier = Modifier
                .size(size = logoWidth.dp)
                .offset(logoXCoord.dp, logoYCoord.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    MyApplicationTheme {
        Map(xPercent = 0.5f, yPercent = 0.5f)
    }
}