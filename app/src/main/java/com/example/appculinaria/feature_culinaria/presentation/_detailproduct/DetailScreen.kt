package com.example.appculinaria.feature_culinaria.presentation._detailproduct

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.appculinaria.feature_culinaria.presentation._detailproduct.components.DetailMealInformation
import com.example.appculinaria.feature_culinaria.presentation._detailproduct.components.DetailViewModel

@Composable
fun DetailScreen(
    onBack:()->Unit,
    viewModel:DetailViewModel = viewModel()
){
    val state = viewModel.state
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        if (state.meal != null){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(state.meal.image)
                    .crossfade(true)
                    .build(),
                contentDescription = "poster",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Box(modifier = Modifier.fillMaxSize().background(
                Brush.verticalGradient(
                    colors = listOf(Color.Black,Color.Black.copy(alpha = 0.2f),Color.Black.copy(alpha = 0.4f),Color.Black.copy(alpha = 0.9f)),
                    tileMode = TileMode.Clamp
                ))
            )

            var yOffSet by remember {
                mutableFloatStateOf(100f)
            }

            DetailMealInformation(
                meal = state.meal,
                modifier = Modifier.align(Alignment.BottomCenter).offset(y = yOffSet.dp)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            val yOffset = (yOffSet + (dragAmount.y / 2)).coerceIn(
                                -300f, 100f
                            )
                        }

                    }
            )

            Box (modifier = Modifier.fillMaxSize().background(
                Brush.verticalGradient(
                    colors = listOf(Color.Transparent,Color.Transparent,Color.Transparent,Color.Black.copy(alpha = 0.7f)),
                    tileMode = TileMode.Clamp
                )
            ))
        }

        IconButton(onClick = {onBack()}, modifier = Modifier.align(Alignment.TopStart)) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)

        }
        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}