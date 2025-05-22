package com.dinoy.forkcast.screens.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoy.forkcast.R
import com.dinoy.forkcast.components.bounceEffectShape
import com.dinoy.forkcast.ui.theme.interFontFamily
import java.time.LocalDate

@Composable
fun HeaderRow(
    onClickNext: () -> Unit,
    onClickPrevious: () -> Unit,
    onCalenderClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Text(
            text = "Weekly Report",
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            fontSize = 18.sp
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            BoxButton(
                icon = painterResource(R.drawable.left)
            )
            {
                onClickNext()
            }
            Spacer(Modifier.width(16.dp))
            BoxButton(
                icon = painterResource(R.drawable.right)
            )
            {
                onClickPrevious()
            }
            Spacer(Modifier.width(24.dp))
            BoxButton(
                icon = painterResource(R.drawable.calendar)
            )
            {
                onCalenderClick()
            }
        }
    }
}


@Composable
fun BoxButton(icon: Painter, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .height(48.dp)
            .bounceEffectShape(
                scaleFactor = .8f,
                initialShape = 20.dp,
                pressedShape = 12.dp,
                onClick = onClick
            )
            .background(color = Color.LightGray.copy(alpha = .3f))
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.Center
    )
    {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = icon,
            contentDescription = "icon",
            tint = Color.DarkGray.copy(alpha = .8f)
        )
    }
}