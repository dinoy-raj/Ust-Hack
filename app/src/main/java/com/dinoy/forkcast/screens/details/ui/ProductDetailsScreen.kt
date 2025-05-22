package com.dinoy.forkcast.screens.details.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dinoy.forkcast.R
import com.dinoy.forkcast.components.CustomisationTile
import com.dinoy.forkcast.components.TileSection
import com.dinoy.forkcast.components.TileSeparator
import com.dinoy.forkcast.models.ForkCastState
import com.dinoy.forkcast.screens.details.components.AverageCountSection
import com.dinoy.forkcast.screens.details.components.GraphSection
import com.dinoy.forkcast.screens.details.components.HeaderRow
import com.dinoy.forkcast.screens.details.data.model.Features
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import com.dinoy.forkcast.ui.theme.interFontFamily
import com.dinoy.forkcast.utils.toPercentageStringFormatted
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter


@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalHazeMaterialsApi::class,
    ExperimentalSharedTransitionApi::class, ExperimentalMaterial3ExpressiveApi::class
)
@Composable
fun ProductDetailsScreen(
    viewModel: ProductDetailsViewModel = hiltViewModel<ProductDetailsViewModel>(),
    category: ProductCategory,
    date: String,
    animatedVisibilityScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
    onBackPress: () -> Unit
) {

    val hazeState = remember { HazeState() }
    val state = viewModel.state

    LaunchedEffect(category) {
        if (state.notFetched) {
            viewModel.setInitialArguments(date, category)
        }
    }

    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = LocalDateTime.of(
            viewModel.state.selectedDate,
            LocalTime.NOON
        ).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    )

    with(sharedTransitionScope) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    modifier = Modifier,
                    title = {
                        Text(
                            modifier = Modifier.padding(start = 24.dp),
                            text = stringResource(category.getNameResourceId()),
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    },
                    navigationIcon = {
                        Icon(
                            modifier = Modifier
                                .clip(CircleShape)
                                .clickable { onBackPress() }
                                .padding(start = 16.dp),
                            painter = painterResource(R.drawable.ic_arrow_left),
                            contentDescription = "nav icon"
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White.copy(alpha = 0f),
                        scrolledContainerColor = Color.White.copy(alpha = 0f),
                        navigationIconContentColor = Color.Black,
                        titleContentColor = Color.Black
                    ),
                )
            },
            contentWindowInsets = WindowInsets(0.dp),
            containerColor = Color.White,
            contentColor = Color.White
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .haze(hazeState)
            )
            {
                item { Spacer(Modifier.height(8.dp)) }

                item {
                    Box(
                        modifier = Modifier
                            .padding(32.dp)
                            .fillMaxWidth()
                            .height(300.dp)
                            .background(
                                color = Color.LightGray.copy(alpha = .3f),
                                shape = RoundedCornerShape(56.dp)
                            )
                            .clip(RoundedCornerShape(56.dp))
                    )
                    {
                        Image(
                            painter = painterResource(category.getImageResourceId()),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .sharedElement(
                                    rememberSharedContentState(key = category.getImageResourceId()),
                                    animatedVisibilityScope = animatedVisibilityScope
                                )
                                .clip(RoundedCornerShape(56.dp)),
                            contentDescription = "image"
                        )
                    }
                }

                item {
                    Spacer(Modifier.height(16.dp))
                }

                item {
                    HeaderRow(
                        onClickNext = {

                        },
                        onClickPrevious = {

                        },
                        onCalenderClick = { showDatePicker = true }
                    )
                }

                item {
                    Spacer(Modifier.height(24.dp))
                }

                item {
                    AverageCountSection(
                        average = state.average,
                        state.selectedCategory
                    )
                }

                item {
                    Spacer(Modifier.height(16.dp))
                }

                item {
                    Box(contentAlignment = Alignment.Center)
                    {
                        GraphSection(viewModel)
                        if (state.queryState == ForkCastState.Loading) {
                            LoadingIndicator(color = Color.Black)
                        }
                    }
                }

                item {
                    Spacer(Modifier.height(32.dp))
                }

                item {
                    Row(
                        Modifier
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Predicted Waste",
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Medium,
                            color = Color.DarkGray,
                            fontSize = 18.sp
                        )

                        Box(
                            modifier = Modifier.background(
                                color = Color.LightGray.copy(alpha = .2f),
                                shape = RoundedCornerShape(16.dp)
                            )
                        )
                        {
                            Text(
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp),
                                text = state.productDetails?.weeklyData[state.selectedIndex]?.date?.format(
                                    DateTimeFormatter.ofPattern("dd MMM")
                                ) ?: "",
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                fontSize = 12.sp
                            )
                        }
                    }

                }

                item {
                    Spacer(Modifier.height(16.dp))
                }

                item {
                    Box()
                    {
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 24.dp)
                                .fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Color.LightGray.copy(alpha = .2f),
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .weight(2f),
                                contentAlignment = Alignment.Center
                            )
                            {
                                Text(
                                    buildAnnotatedString {
                                        append(
                                            "${
                                                String.format(
                                                    "%.2f",
                                                    state.productDetails?.weeklyData[state.selectedIndex]?.quantity
                                                )
                                            }"
                                        )
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
                                    },
                                    fontFamily = interFontFamily,
                                    fontSize = 40.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(vertical = 16.dp)
                                )
                            }
                            Box(Modifier.width(16.dp))
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Color.LightGray.copy(alpha = .2f),
                                        shape = RoundedCornerShape(16.dp)
                                    )
                                    .weight(1f),
                                contentAlignment = Alignment.Center
                            )
                            {
                                Column(
                                    modifier = Modifier,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {

                                    Text(
                                        text = state.productDetails?.weeklyData[state.selectedIndex]?.accuracy?.toPercentageStringFormatted()
                                            .orEmpty(),
                                        fontFamily = interFontFamily,
                                        fontSize = 24.sp,
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(top = 16.dp)
                                    )

                                    Text(
                                        modifier = Modifier.padding(
                                            vertical = 8.dp,
                                            horizontal = 16.dp
                                        ),
                                        text = stringResource(R.string.confidence),
                                        fontFamily = interFontFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.LightGray,
                                        fontSize = 10.sp
                                    )
                                }


                            }
                        }
                    }
                }

                item {
                    Spacer(Modifier.height(32.dp))
                }

                item {
                    Text(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        text = "Conditions Influenced",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color.DarkGray,
                        fontSize = 18.sp
                    )
                }

                item {
                    Spacer(Modifier.height(24.dp))
                }

                item {
                    TileSection {
                        Column {
                            viewModel.features.filter {
                                it != Features.None
                            }.forEach {
                                Column {
                                    CustomisationTile(
                                        iconContent = {
                                            Icon(
                                                imageVector = it.getIcon(),
                                                contentDescription = "list",
                                                tint = Color.DarkGray,
                                                modifier = Modifier
                                                    .size(16.dp),
                                            )
                                        },
                                        title = stringResource(it.getNameResourceId()),
                                        trailingContent = {
                                            Box(
                                                modifier = Modifier
                                                    .background(
                                                        color = Color.Black,
                                                        shape = RoundedCornerShape(16.dp)
                                                    )
                                            )
                                            {
                                                Text(
                                                    modifier = Modifier.padding(
                                                        vertical = 4.dp,
                                                        horizontal = 16.dp
                                                    ),
                                                    text = when (it) {
                                                        is Features.Holiday -> "${it.percentage}%"
                                                        is Features.Humidity -> "${it.percentage}%"
                                                        Features.None -> "${0}%"
                                                        is Features.Rainy -> "${it.percentage}%"
                                                        is Features.Sunny -> "${it.percentage}%"
                                                        is Features.Temperature -> "${it.percentage}%"
                                                        is Features.WeekDay -> "${it.percentage}%"
                                                        is Features.Weekend -> "${it.percentage}%"
                                                    },
                                                    fontFamily = interFontFamily,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = Color.White,
                                                    fontSize = 15.sp
                                                )
                                            }
                                        }
                                    ) { }
                                    TileSeparator()
                                }
                            }
                        }
                    }
                }


                item {
                    Spacer(Modifier.height(100.dp))
                }
            }
        }



        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = {
                    showDatePicker = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.setSelectedDate(
                                Instant.ofEpochMilli(
                                    datePickerState.selectedDateMillis ?: 0,
                                ).atZone(ZoneId.systemDefault()).toLocalDate()
                            )
                            showDatePicker = false
                        },
                    ) {
                        androidx.compose.material.Text(stringResource(R.string.ok))
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }) {
                        androidx.compose.material.Text(stringResource(R.string.cancel))
                    }
                },
            ) {
                DatePicker(state = datePickerState)
            }
        }
    }
}