package com.dinoy.forkcast.screens.listing.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoy.forkcast.components.bounceEffectShape
import com.dinoy.forkcast.ui.theme.interFontFamily

@Composable
fun ProductCard(
    modifier: Modifier,
    image: Int,
    name: Int,
    weight: Double,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .bounceEffectShape(
                scaleFactor = .95f,
                pressedShape = 12.dp,
                initialShape = 24.dp
            )
            {
                onClick()
            }
            .background(color = Color.White)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start
        )
        {
            Box(
                modifier = Modifier
                    .height(72.dp)
                    .fillMaxWidth()
                    .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp))
            )
            {
                Image(
                    painter = painterResource(image),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(16.dp)
                        .width(2.dp)
                        .background(
                            color = Color.DarkGray.copy(alpha = .2f),
                            shape = RoundedCornerShape(10.dp)
                        )
                )
                Text(
                    stringResource(name),
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp,
                    fontFamily = interFontFamily,
                    color = Color.DarkGray.copy(alpha = .6f)
                )
            }

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.LightGray.copy(alpha = .4f),
            )

            Text(
                text = "${weight} kg",
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                fontFamily = interFontFamily,
                color = Color.DarkGray
            )

        }
    }
}