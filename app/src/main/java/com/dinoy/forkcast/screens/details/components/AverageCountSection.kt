package com.dinoy.forkcast.screens.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoy.forkcast.ui.theme.interFontFamily

@Composable
fun AverageCountSection(average: Double = 0.0) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    )
    {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            Text(
                buildAnnotatedString {
                    append("$average")
                    withStyle(
                        style = TextStyle(
                            fontFamily = interFontFamily,
                            fontSize = 18.sp,
                            color = Color.DarkGray,
                            fontWeight = FontWeight.SemiBold
                        ).toSpanStyle()
                    ) {
                        append(" KG")
                    }

                    withStyle(
                        style = TextStyle(
                            fontFamily = interFontFamily,
                            fontSize = 12.sp,
                            color = Color.DarkGray.copy(.7f),
                            fontWeight = FontWeight.Medium
                        ).toSpanStyle()
                    ) {
                        append(" - waste per day(avg)")
                    }


                },
                fontFamily = interFontFamily,
                fontSize = 40.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = "These are Calculated Based on 100kg of product produced on daily basis.",
            fontFamily = interFontFamily,
            fontSize = 12.sp,
            color = Color.DarkGray.copy(.7f),
            lineHeight = 15.sp
        )
    }
}