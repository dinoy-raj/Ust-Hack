package com.dinoy.forkcast.screens.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.MarkEmailUnread
import androidx.compose.material.icons.outlined.NotificationAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dinoy.forkcast.R
import com.dinoy.forkcast.components.DinoImage
import com.dinoy.forkcast.components.bounceEffect
import com.dinoy.forkcast.ui.theme.interFontFamily
import com.dinoy.forkcast.utils.toPercentageStringFormatted
import java.time.format.DateTimeFormatter

@Composable
fun LandingScreen(controller: NavHostController) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
        }

        item {
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .bounceEffect(scaleFactor = .9f) {

                        }
                        .size(48.dp)
                        .border(
                            width = 1.dp,
                            color = Color.DarkGray.copy(alpha = .3f),
                            RoundedCornerShape(16.dp)
                        )
                        .clip(RoundedCornerShape(16.dp))
                )
                {
                    DinoImage(imageUrl = "https://plus.unsplash.com/premium_photo-1661883237884-263e8de8869b?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cmVzdGF1cmFudHxlbnwwfHwwfHx8MA%3D%3D")
                }


                Box(
                    modifier = Modifier
                        .bounceEffect(scaleFactor = .9f) {

                        }
                        .size(48.dp)
                        .border(
                            width = 1.dp,
                            color = Color.DarkGray.copy(alpha = .1f),
                            RoundedCornerShape(16.dp)
                        )
                        .clip(RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                )
                {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Outlined.NotificationAdd,
                        contentDescription = "list",
                        tint = Color.DarkGray,
                        modifier = Modifier
                            .size(16.dp),
                    )
                }
            }
        }


        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            )
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
                        androidx.compose.material3.Text(
                            buildAnnotatedString {
                                append("234")
                                withStyle(
                                    style = TextStyle(
                                        fontFamily = interFontFamily,
                                        fontSize = 18.sp,
                                        color = Color.DarkGray,
                                        fontWeight = FontWeight.SemiBold
                                    ).toSpanStyle()
                                ) {
                                    append("/566 KG")
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

                            androidx.compose.material3.Text(
                                text = "34%"
                                    .orEmpty(),
                                fontFamily = interFontFamily,
                                fontSize = 24.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 16.dp)
                            )

                            androidx.compose.material3.Text(
                                modifier = Modifier.padding(
                                    vertical = 8.dp,
                                    horizontal = 16.dp
                                ),
                                text = "Waste Eliminated",
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
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
            )
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    androidx.compose.material3.Text(
                        text = "Spotlight",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.DarkGray.copy(alpha = .7f),
                        fontSize = 14.sp
                    )

                    Box(
                        modifier = Modifier.background(
                            color = Color.LightGray.copy(alpha = .2f),
                            shape = RoundedCornerShape(16.dp)
                        )
                    )
                    {
                        androidx.compose.material3.Text(
                            modifier = Modifier.padding(vertical = 2.dp, horizontal = 12.dp),
                            text = "View More",
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.DarkGray.copy(alpha = .5f),
                            fontSize = 8.sp
                        )
                    }
                }
            }
        }


        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            )
        }

        item {
            Box(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.LightGray.copy(alpha = .1f),
                        shape = RoundedCornerShape(48.dp)
                    )
            )
            {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                )
                {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Outlined.AutoAwesome,
                        contentDescription = "list",
                        tint = Color.DarkGray,
                        modifier = Modifier
                            .size(16.dp),
                    )

                    androidx.compose.material3.Text(
                        modifier = Modifier.padding(end = 8.dp),
                        text = "Local festival starts on Friday. Historical data indicates 30% increase in demand for desserts.",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.DarkGray.copy(alpha = .7f),
                        fontSize = 12.sp,
                        lineHeight = 15.sp
                    )

                }
            }
        }

        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
            )
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    androidx.compose.material3.Text(
                        text = "Featured Insights",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.DarkGray.copy(alpha = .7f),
                        fontSize = 14.sp
                    )

                    Box(
                        modifier = Modifier.background(
                            color = Color.LightGray.copy(alpha = .2f),
                            shape = RoundedCornerShape(16.dp)
                        )
                    )
                    {
                        androidx.compose.material3.Text(
                            modifier = Modifier.padding(vertical = 2.dp, horizontal = 12.dp),
                            text = "View More",
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.DarkGray.copy(alpha = .5f),
                            fontSize = 8.sp
                        )
                    }
                }
            }
        }


        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
            )
        }


        item {
            Box(
                Modifier
                    .padding(horizontal = 24.dp)
                    .background(
                        color = Color.LightGray.copy(alpha = .2f), shape = RoundedCornerShape(
                            24.dp
                        )
                    )
                    .fillMaxWidth()
            )
            {
                Column(
                    Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                )
                {
                    Box(
                        modifier = Modifier
                            .alpha(.8f)
                            .height(200.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    {
                        DinoImage(imageUrl = "https://images.healthshots.com/healthshots/en/uploads/2023/04/11181646/seasonal-food.jpg")
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        androidx.compose.material3.Text(
                            text = "Prepare for seasonal waste elimination",
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray,
                            fontSize = 14.sp
                        )

                        androidx.compose.material3.Text(
                            modifier = Modifier.padding(end = 8.dp),
                            text = "The best way to manage seasonal waste is to plan for it. \"Prepare for Seasonal Waste Elimination\" provides the framework and insights needed to read more",
                            fontFamily = interFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = Color.DarkGray.copy(alpha = .7f),
                            fontSize = 8.sp,
                            lineHeight = 10.sp
                        )

                        Box(Modifier.height(8.dp))
                    }

                }
            }
        }


    }
}