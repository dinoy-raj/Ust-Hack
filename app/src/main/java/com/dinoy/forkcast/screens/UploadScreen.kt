package com.dinoy.forkcast.screens

import android.widget.Space
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dinoy.forkcast.ui.theme.interFontFamily

@Composable
fun UploadScreen() {
    Box {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
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
                        horizontalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            androidx.compose.material3.Text(
                                text = "Waste History Upload",
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.DarkGray,
                                fontSize = 18.sp
                            )

                            androidx.compose.material3.Text(
                                text = "Holiday calender specific to your region",
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Normal,
                                color = Color.DarkGray.copy(alpha = .7f),
                                fontSize = 10.sp,
                                lineHeight = 14.sp
                            )
                        }

                        Box(
                            modifier = Modifier.background(
                                color = Color.Black,
                                shape = RoundedCornerShape(16.dp)
                            )
                        )
                        {
                            androidx.compose.material3.Text(
                                modifier = Modifier.padding(vertical = 2.dp, horizontal = 12.dp),
                                text = "Upload New Calender",
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                fontSize = 8.sp
                            )
                        }
                    }
                }
            }


            item {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(
                            color = Color.LightGray.copy(alpha = .1f),
                            shape = RoundedCornerShape(24.dp)
                        ),
                    contentAlignment = Alignment.Center
                )
                {
                    androidx.compose.material3.Text(
                        modifier = Modifier.padding(vertical = 2.dp, horizontal = 12.dp),
                        text = "Today is working day",
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.LightGray,
                        fontSize = 15.sp
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
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
                        horizontalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            androidx.compose.material3.Text(
                                text = "Waste History Upload",
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.DarkGray,
                                fontSize = 18.sp
                            )

                            androidx.compose.material3.Text(
                                text = "Upload category wise daily produced waste data",
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.Normal,
                                color = Color.DarkGray.copy(alpha = .7f),
                                fontSize = 10.sp,
                                lineHeight = 14.sp
                            )
                        }

                        Box(
                            modifier = Modifier.background(
                                color = Color.Black,
                                shape = RoundedCornerShape(16.dp)
                            )
                        )
                        {
                            androidx.compose.material3.Text(
                                modifier = Modifier.padding(vertical = 2.dp, horizontal = 12.dp),
                                text = "Upload Data",
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                fontSize = 8.sp
                            )
                        }
                    }
                }
            }

            items(5) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color.LightGray.copy(alpha = .2f),
                            shape = RoundedCornerShape(16.dp)
                        )
                )
                {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Box(
                            modifier = Modifier
                                .height(10.dp)
                                .width(4.dp)
                                .background(
                                    color = Color.Black, shape = CircleShape
                                )
                        )

                        Box()
                        {
                            androidx.compose.material3.Text(
                                text = "dump_data_2025_may ${(20..30).random()}",
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.DarkGray,
                                fontSize = 16.sp
                            )
                        }


                    }
                }
            }
        }


    }
}