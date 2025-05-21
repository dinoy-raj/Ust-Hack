package com.dinoy.forkcast.screens.listing.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProductListingScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .background(color = Color(0xFFF3F7FA))
                .padding(it)
                .fillMaxSize(), verticalArrangement = Arrangement.spacedBy(24.dp)
        )
        {
            item {
                Spacer(Modifier.height(32.dp))
            }

            items(10) {

            }

            item {
                Spacer(Modifier.height(32.dp))
            }
        }
    }
}