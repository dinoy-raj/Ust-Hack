package com.dinoy.forkcast.screens.details.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dinoy.forkcast.R
import com.dinoy.forkcast.screens.details.components.AverageCountSection
import com.dinoy.forkcast.screens.details.components.GraphSection
import com.dinoy.forkcast.screens.details.components.HeaderRow
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import com.dinoy.forkcast.ui.theme.interFontFamily
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import java.time.LocalDate


@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalHazeMaterialsApi::class,
    ExperimentalSharedTransitionApi::class
)
@Composable
fun ProductDetailsScreen(
    category: ProductCategory,
    date: String,
    animatedVisibilityScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope
) {

    val hazeState = remember { HazeState() }

    LaunchedEffect(category) {

    }

    with(sharedTransitionScope) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    modifier = Modifier.hazeChild(hazeState, HazeMaterials.regular()),
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
                            modifier = Modifier.padding(start = 16.dp),
                            painter = painterResource(R.drawable.ic_arrow_left),
                            contentDescription = "nav icon"
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White.copy(alpha = 0f),
                        scrolledContainerColor = Color.White.copy(alpha = 0f),
                        navigationIconContentColor = Color.Black,
                        titleContentColor = Color.Black
                    )
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
                        currentDate = LocalDate.now(),
                        onClickNext = {},
                        onClickPrevious = {},
                        onCalenderClick = {}
                    )
                }

                item {
                    Spacer(Modifier.height(24.dp))
                }

                item {
                    AverageCountSection()
                }

                item {
                    Spacer(Modifier.height(16.dp))
                }

                item {
                    GraphSection()
                }

                item {
                    Spacer(Modifier.height(24.dp))
                }


                item {
                    Spacer(Modifier.height(800.dp))
                }
            }
        }
    }
}