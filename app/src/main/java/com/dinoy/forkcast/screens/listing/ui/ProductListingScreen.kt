package com.dinoy.forkcast.screens.listing.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoy.forkcast.R
import com.dinoy.forkcast.components.bounceEffect
import com.dinoy.forkcast.components.bounceEffectShape
import com.dinoy.forkcast.screens.listing.components.ProductCard
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import com.dinoy.forkcast.ui.theme.interFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListingScreen() {
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

                            }
                            .padding(horizontal = 32.dp, vertical = 24.dp)
                            .fillMaxWidth()
                            .background(
                                color = Color.LightGray.copy(alpha = .3f),
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
                                text = "12 December 2025",
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
        LazyVerticalGrid(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            columns = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        )
        {
            ProductCategory.entries.forEach {
                item {
                    ProductCard(
                        modifier = Modifier.animateItem(),
                        image = it.getImageResourceId(),
                        name = it.getNameResourceId(),
                        weight = (10..20).random().toDouble()
                    )
                    {

                    }
                }
            }
        }
    }
}