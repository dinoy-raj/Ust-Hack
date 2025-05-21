package com.dinoy.forkcast.screens.listing.ui.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dinoy.forkcast.screens.listing.components.ProductCard
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory

@Composable
fun ListingContent()
{
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize(),
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    )
    {
        item{
            Spacer(Modifier.height(16.dp))
        }

        item{
            Spacer(Modifier.height(16.dp))
        }

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

        item{
            Spacer(Modifier.height(48.dp))
        }

        item{
            Spacer(Modifier.height(48.dp))
        }
    }
}