package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme


@Composable
fun MapSlider(coord: Float, title: String, update: (Float) -> Unit) {
    val amount = (coord * 100).toInt()
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

@Preview(showBackground = true)
@Composable
fun MapSliderPreview() {
    MyApplicationTheme {
        val x = 150
        val update = fun (x: Float) {

        }
        MapSlider(coord = 0.5f, title = "My Map", update = update)
    }
}