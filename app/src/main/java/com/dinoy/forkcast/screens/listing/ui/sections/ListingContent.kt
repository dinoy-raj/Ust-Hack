package com.dinoy.forkcast.screens.listing.ui.sections

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dinoy.forkcast.screens.listing.components.ProductCard
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import com.dinoy.forkcast.screens.listing.data.models.ProductData

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ListingContent(
    productData: SnapshotStateList<ProductData>,
    animatedVisibilityScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
    onClick: (ProductCategory) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize(),
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    )
    {
        item {
            Spacer(Modifier.height(16.dp))
        }

        item {
            Spacer(Modifier.height(16.dp))
        }

        items(productData, key = { it.category }) {
            ProductCard(
                modifier = Modifier.animateItem(),
                image = it.category.getImageResourceId(),
                name = it.category.getNameResourceId(),
                animatedVisibilityScope = animatedVisibilityScope,
                sharedTransitionScope = sharedTransitionScope,
                weight = it.quantity
            )
            {
                onClick(it.category)
            }
        }

        item {
            Spacer(Modifier.height(48.dp))
        }

        item {
            Spacer(Modifier.height(48.dp))
        }
    }
}