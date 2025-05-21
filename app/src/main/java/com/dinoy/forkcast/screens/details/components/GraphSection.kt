package com.dinoy.forkcast.screens.details.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoy.forkcast.components.bounceEffectShape
import com.dinoy.forkcast.ui.theme.interFontFamily

@Composable
fun GraphSection() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(300.dp)
    )
    {
        GraphContentSection(modifier = Modifier.weight(1f))
        GraphContentScale()
    }
}

@Composable
fun GraphContentSection(modifier: Modifier = Modifier) {

    var selectedIndex by remember { mutableIntStateOf(3) }

    Box(modifier = modifier)
    {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            DayComponent(
                modifier = Modifier.weight(1f),
                day = "M",
                value = .3f,
                isSelected = selectedIndex == 0
            )
            {
                selectedIndex = 0
            }

            DayComponent(
                modifier = Modifier.weight(1f),
                day = "T",
                value = .4f,
                isSelected = selectedIndex == 1
            )
            {
                selectedIndex = 1
            }

            DayComponent(
                modifier = Modifier.weight(1f),
                day = "W",
                value = .8f,
                isSelected = selectedIndex == 2
            )
            {
                selectedIndex = 2
            }

            DayComponent(
                modifier = Modifier.weight(1f),
                day = "T",
                value = .6f,
                isSelected = selectedIndex == 3
            )
            {
                selectedIndex = 3
            }

            DayComponent(
                modifier = Modifier.weight(1f),
                day = "F",
                value = .3f,
                isSelected = selectedIndex == 4
            )
            {
                selectedIndex = 4
            }

            DayComponent(
                modifier = Modifier.weight(1f),
                day = "S",
                value = .5f,
                isSelected = selectedIndex == 5
            )
            {
                selectedIndex = 5
            }
            DayComponent(
                modifier = Modifier.weight(1f),
                day = "S",
                value = .7f,
                isSelected = selectedIndex == 6
            )
            {
                selectedIndex = 6
            }

            Spacer(modifier = Modifier.width(24.dp))
        }


    }
}


@Composable
fun GraphContentScale() {
    Box(
        modifier = Modifier
            .padding(bottom = 40.dp)
            .fillMaxHeight()
    )
    {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(
                text = "100",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray.copy(alpha = .6f),
                fontSize = 10.sp
            )

            Text(
                text = "75",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray.copy(alpha = .6f),
                fontSize = 10.sp
            )

            Text(
                text = "50",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray.copy(alpha = .6f),
                fontSize = 10.sp
            )

            Text(
                text = "25",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray.copy(alpha = .6f),
                fontSize = 10.sp
            )

            Text(
                text = "0",
                fontFamily = interFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray.copy(alpha = .6f),
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun DayComponent(
    modifier: Modifier = Modifier,
    day: String,
    value: Float,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {

    val color by animateColorAsState(
        targetValue = if (isSelected) Color.Black else Color.DarkGray.copy(alpha = .1f),
        animationSpec = spring(
            stiffness = Spring.StiffnessVeryLow
        )
    )

    val colorCircle by animateColorAsState(
        targetValue = if (isSelected) Color.White else Color.DarkGray.copy(alpha = .1f),
        animationSpec = spring(
            stiffness = Spring.StiffnessVeryLow
        )
    )

    val colorText by animateColorAsState(
        targetValue = if (isSelected) Color.DarkGray else Color.DarkGray.copy(alpha = .6f),
        animationSpec = spring(
            stiffness = Spring.StiffnessVeryLow
        )
    )

    val height by animateFloatAsState(
        targetValue = value,
        animationSpec = spring(
            stiffness = Spring.StiffnessVeryLow
        )
    )

    Column(
        modifier = modifier
            .padding(horizontal = 4.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .bounceEffectShape(
                        scaleFactor = .8f
                    )
                    {
                        onClick()
                    }
                    .background(
                        color = color,
                    )
                    .fillMaxHeight(height),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                AnimatedVisibility(visible = isSelected, enter = scaleIn(), exit = scaleOut()) {
                    Box(modifier = Modifier
                        .size(8.dp)
                        .background(colorCircle, shape = CircleShape))
                    {

                    }
                }

            }
        }

        Spacer(Modifier.height(16.dp))

        Box(modifier = Modifier.size(24.dp), contentAlignment = Alignment.Center)
        {
            Text(
                day,
                fontFamily = interFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = colorText
            )
        }
    }
}