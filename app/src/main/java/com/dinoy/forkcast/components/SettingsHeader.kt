package com.dinoy.forkcast.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoy.forkcast.ui.theme.interFontFamily

@Composable
fun SettingsHeader(title: String) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart)
    {
        Row(
            modifier = Modifier
                .padding(start = 24.dp)
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Box(
                    Modifier
                        .height(12.dp)
                        .width(2.dp)
                        .background(
                            color = Color.Black,
                            shape = RoundedCornerShape(40.dp)
                        )
                )
            }
            Text(
                text = title,
                textAlign = TextAlign.Start,
                color = Color.DarkGray,
                fontSize = 14.sp,
                fontFamily = interFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }
    }

}