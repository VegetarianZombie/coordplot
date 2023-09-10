package com.kodeco.android.coordplot

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                PlotSurface()
            }
        }
    }
}

@Composable
fun PlotSurface() {
    var xPercentage: Float by remember { mutableFloatStateOf(0.5f) }
    var yPercentage: Float by remember { mutableFloatStateOf(0.5f) }
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

@Composable
fun MapSlider(coord: Float, title: String, update: (Float) -> Unit) {
    var amount = (coord * 100).toInt()
    val sliderText = "$title: $amount%"
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)) {
        Text(
            text = sliderText, modifier = Modifier
                .width(120.dp)
        )
        Slider(
            value = coord,
            onValueChange = update
        )
    }
}

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {
    val boxWidth = 300
    val boxHeight = 300
    val logoWidth = 45
    val logoHeight = 45
    val logoXCoord = (xPercent * (boxWidth - logoWidth))
    val logoYCoord = (yPercent * (boxHeight - logoHeight))

    Box {
        Box(
            modifier = Modifier
                .size(boxWidth.dp)
                .background(Color.Black)
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
