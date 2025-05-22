package com.dinoy.forkcast.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoy.forkcast.ui.theme.interFontFamily


@Composable
fun CustomisationTile(
    modifier: Modifier = Modifier,
    title: String,
    iconContent: @Composable () -> Unit = {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.List,
            contentDescription = "list",
            tint = Color.DarkGray,
            modifier = Modifier
                .size(16.dp),
        )
    },
    trailingContent: @Composable () -> Unit = {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
            contentDescription = "list",
            tint = Color.DarkGray,
            modifier = Modifier
                .size(24.dp),
        )
    },
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .bounceEffect(.95f)
            {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        Box(
            modifier = Modifier
                .background(
                    color = Color.DarkGray.copy(alpha = .1f),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
        )
        {
            iconContent()
        }

        Text(
            text = title,
            textAlign = TextAlign.Start,
            color = Color.DarkGray,
            fontFamily = interFontFamily,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        trailingContent()

    }
}


@Composable
fun CustomisationTileWithOutIcon(
    modifier: Modifier = Modifier,
    title: String,
    trailingContent: @Composable () -> Unit = {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
            contentDescription = "list",
            tint = Color.DarkGray,
            modifier = Modifier
                .size(24.dp),
        )
    },
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .bounceEffect(.95f)
            {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    )
    {

        Text(
            text = title,
            textAlign = TextAlign.Start,
            color = Color.DarkGray,
            fontFamily = interFontFamily,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        trailingContent()

    }
}

@Composable
fun CustomisationTileWithRadio(text: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .bounceEffect(.95f) { onClick() }
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Text(
            text = text,
            textAlign = TextAlign.Start,
            color = Color.DarkGray,
            fontSize = 10.sp,
            fontFamily = interFontFamily
        )

        RadioButton(
            selected = selected,
            onClick = null
        )
    }
}