package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun PlotSurface() {
    var xPercentage: Float by rememberSaveable { mutableFloatStateOf(0.5f) }
    var yPercentage: Float by rememberSaveable { mutableFloatStateOf(0.5f) }
    var updateXPercentage = fun(currentX: Float) {
        xPercentage = currentX;
    }
    var updateYPercentage = fun(currentY: Float) {
        yPercentage = currentY;
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 16.dp)) {
            Map(xPercent = xPercentage, yPercent = yPercentage)
            MapSlider(
                coord = xPercentage,
                title = "X Axis",
                update = updateXPercentage
            )
            MapSlider(
                coord = yPercentage,
                title = "Y Axis",
                update = updateYPercentage
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlotSurfacePreview() {
    MyApplicationTheme {
        PlotSurface()
    }
}