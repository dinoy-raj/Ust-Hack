package com.dinoy.forkcast.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoy.forkcast.ui.theme.interFontFamily


@Composable
fun TileSection(content: @Composable () -> Unit) {
    Box(
        Modifier
            .padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                color = Color.LightGray.copy(alpha = .1f),
                shape = RoundedCornerShape(24.dp)
            )
            .fillMaxWidth()
            .background(color = Color.LightGray.copy(alpha = .1f)),
        contentAlignment = Alignment.Center
    )
    {
        content()
    }
}

@Composable
fun TileComponent(label: String, onClick: () -> Unit) {

    Box(
        Modifier
            .fillMaxWidth()
            .bounceEffect(scaleFactor = .95f) {
                onClick()
            }
            .background(color = Color.LightGray.copy(alpha = .1f)),
        contentAlignment = Alignment.CenterStart
    )
    {
        Text(
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 20.dp
            ),
            text = label,
            color = Color.LightGray,
            fontFamily = interFontFamily,
            fontSize = 15.sp
        )
    }

}

@Composable
fun TileSeparator() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(color = Color.White)
    )
}