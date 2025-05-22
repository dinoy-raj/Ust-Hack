package com.dinoy.forkcast.screens.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MarkEmailUnread
import androidx.compose.material.icons.outlined.NotificationAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dinoy.forkcast.components.DinoImage
import com.dinoy.forkcast.components.bounceEffect
import com.dinoy.forkcast.ui.theme.interFontFamily
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
                            RoundedCornerShape(12.dp)
                        )
                        .clip(RoundedCornerShape(12.dp))
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
                            color = Color.DarkGray.copy(alpha = .3f),
                            RoundedCornerShape(12.dp)
                        )
                        .clip(RoundedCornerShape(12.dp)),
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
                    .height(24.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .height(350.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.LightGray.copy(alpha = .1f), shape = RoundedCornerShape(32.dp)
                    )
            )
            {

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
            Box(modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth())
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
                        fontSize = 16.sp
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


    }
}