package com.dinoy.forkcast.components

import android.graphics.Paint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ForkCastLoader() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Box(modifier = Modifier.size(56.dp), contentAlignment = Alignment.Center)
        {
            LoadingIndicator(color = Color.Black, modifier = Modifier.fillMaxSize())
        }

    }
}