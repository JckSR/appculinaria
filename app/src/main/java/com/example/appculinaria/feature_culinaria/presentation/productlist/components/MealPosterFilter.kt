package com.example.appculinaria.feature_culinaria.presentation.productlist.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import  com.example.appculinaria.feature_culinaria.presentation.util.PosterSize

@Composable
fun MealPosterFilter(
    imageUrl:String,
    posterSize:PosterSize,
    onClickMeal:()->Unit
){
    val height = if(posterSize == PosterSize.SMALL) 180 else 205
    val width = if (posterSize== PosterSize.SMALL) 138 else 156

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = "Background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

}