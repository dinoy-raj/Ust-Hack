package com.dinoy.forkcast.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.dinoy.forkcast.R

@Composable
fun DinoImage(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    contentScale: ContentScale = ContentScale.Crop,
    @DrawableRes placeHolder: Int = R.drawable.ic_placeholder,
) {
    val context = LocalContext.current
    Box(modifier) {
        AsyncImage(
            modifier = modifier,
            model =
                ImageRequest.Builder(context)
                    .data(imageUrl)
                    .crossfade(true)
                    .networkCachePolicy(CachePolicy.ENABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .memoryCacheKey(imageUrl)
                    .build(),
            contentScale = contentScale,
            contentDescription = "image",
            placeholder = painterResource(placeHolder),
            error = painterResource(placeHolder),
            fallback = painterResource(placeHolder),
        )
    }
}
