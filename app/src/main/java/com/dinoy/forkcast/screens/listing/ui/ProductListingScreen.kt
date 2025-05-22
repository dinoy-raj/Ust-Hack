package com.dinoy.forkcast.screens.listing.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dinoy.forkcast.R
import com.dinoy.forkcast.components.ErrorScreen
import com.dinoy.forkcast.components.ForkCastLoader
import com.dinoy.forkcast.components.bounceEffect
import com.dinoy.forkcast.models.ForkCastState
import com.dinoy.forkcast.navigation.InnerRoutes
import com.dinoy.forkcast.screens.listing.ui.sections.ListingContent
import com.dinoy.forkcast.ui.theme.interFontFamily
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter


@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class,
    ExperimentalSharedTransitionApi::class
)
@Composable
fun ProductListingScreen(
    viewModel: ProductListingViewModel = hiltViewModel<ProductListingViewModel>(),
    animatedVisibilityScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
    onClick: (Any) -> Unit
) {

    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = LocalDateTime.of(
            viewModel.state.selectedDate,
            LocalTime.NOON
        ).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    )
    val state = viewModel.state

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0.dp),
        containerColor = Color(0xFFEEF0F4),
        contentColor = Color(0xFFEEF0F4),
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .bounceEffect(scaleFactor = .95f) {
                                showDatePicker = true
                            }
                            .padding(horizontal = 32.dp, vertical = 24.dp)
                            .fillMaxWidth()
                            .background(
                                color = Color.LightGray.copy(alpha = .3f),
                                shape = RoundedCornerShape(24.dp)
                            ).border(
                                width = 1.dp,
                                color = Color.LightGray.copy(alpha = .6f),
                                shape = RoundedCornerShape(24.dp)
                            ),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.calendar),
                                modifier = Modifier.size(24.dp),
                                contentDescription = "calender",
                                tint = Color.DarkGray.copy(alpha = .8f)
                            )
                            Spacer(Modifier.width(16.dp))
                            Text(
                                text = state.selectedDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")),
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(vertical = 12.dp),
                                color = Color.DarkGray.copy(alpha = .6f)
                            )
                        }

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = Color.White,
                    containerColor = Color.White
                )
            )
        },
        floatingActionButton = {
//            FloatingActionButton(
//                modifier = Modifier
//                    .padding(
//                        horizontal = 24.dp,
//                        vertical = 48.dp
//                    )
//                    .bounceEffectShape(
//                        scaleFactor = .95f,
//                        pressedShape = 50.dp,
//                        initialShape = 16.dp
//                    )
//                    {
//
//                    },
//                onClick = { /*TODO*/ },
//                shape = RoundedCornerShape(16.dp),
//                containerColor = Color.Black
//            ) {
//                Icon(
//                    modifier = Modifier.padding(12.dp),
//                    painter = painterResource(R.drawable.calendar),
//                    contentDescription = "add",
//                    tint = Color.LightGray
//                )
//            }
        }
    ) {

        AnimatedContent(
            targetState = state.queryState,
            modifier = Modifier.padding(it),
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            }) {
            when (it) {
                ForkCastState.Loading -> {
                    ForkCastLoader()
                }

                ForkCastState.NetworkError -> {
                    ErrorScreen()
                }

                ForkCastState.NoResult -> {
                    ErrorScreen()
                }

                ForkCastState.ServerError -> {
                    ErrorScreen()
                }

                ForkCastState.Success -> {
                    ListingContent(
                        viewModel.productData,
                        animatedVisibilityScope,
                        sharedTransitionScope
                    )
                    {
                        onClick(
                            InnerRoutes.Details(
                                product = it.name,
                                date = viewModel.state.selectedDate.toString()
                            )
                        )
                    }
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