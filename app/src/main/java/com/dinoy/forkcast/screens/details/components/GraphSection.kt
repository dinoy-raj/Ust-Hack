package com.dinoy.forkcast.screens.details.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoy.forkcast.components.bounceEffectShape
import com.dinoy.forkcast.screens.details.ui.ProductDetailsViewModel
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import com.dinoy.forkcast.ui.theme.interFontFamily
import com.dinoy.forkcast.utils.getComparisonValue
import com.dinoy.forkcast.utils.getDayInitial

@Composable
fun GraphSection(viewModel: ProductDetailsViewModel) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(300.dp)
    )
    {
        GraphContentSection(modifier = Modifier.weight(1f), viewModel)
        GraphContentScale(viewModel)
    }
}

@Composable
fun GraphContentSection(modifier: Modifier = Modifier, viewModel: ProductDetailsViewModel) {

    val state = viewModel.state

    Box(modifier = modifier)
    {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            state.productDetails?.weeklyData?.forEachIndexed { index, item ->
                DayComponent(
                    modifier = Modifier.weight(1f),
                    day = getDayInitial(item.date),
                    value = ((item.quantity / getComparisonValue(state.selectedCategory)).toFloat()),
                    isSelected = state.selectedIndex == index
                )
                {
                    viewModel.setSelectedIndex(index)
                }
            }
            Spacer(modifier = Modifier.width(24.dp))
        }


    }
}


@Composable
fun GraphContentScale(viewModel: ProductDetailsViewModel) {
    val state = viewModel.state

    Box(
        modifier = Modifier
            .padding(bottom = 24.dp)
            .fillMaxHeight()
    )
    {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(
                text = when (state.selectedCategory) {
                    ProductCategory.MainCourse -> "80"
                    else -> "40"
                },
                fontFamily = interFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray.copy(alpha = .6f),
                fontSize = 10.sp
            )

            Text(
                text = when (state.selectedCategory) {
                    ProductCategory.MainCourse -> "60"
                    else -> "30"
                },
                fontFamily = interFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray.copy(alpha = .6f),
                fontSize = 10.sp
            )

            Text(
                text = when (state.selectedCategory) {
                    ProductCategory.MainCourse -> "40"
                    else -> "20"
                },
                fontFamily = interFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray.copy(alpha = .6f),
                fontSize = 10.sp
            )

            Text(
                text = when (state.selectedCategory) {
                    ProductCategory.MainCourse -> "20"
                    else -> "10"
                },
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
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(colorCircle, shape = CircleShape)
                    )
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