package com.example.appculinaria.feature_culinaria.presentation.productlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appculinaria.feature_culinaria.domain.model.Meal
import com.example.appculinaria.feature_culinaria.presentation.productlist.components.HomeMealList

@Composable
fun MealListScreen(
    onMealClick:(Meal)->Unit,
    viewModel: MealListViewModel = viewModel()
){
    val state = viewModel.state

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().padding(start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item (span = {
            GridItemSpan(2)

        }){

        }

        if(state.upComing.isNotEmpty()){
            item(span = {
                GridItemSpan(2)
            }){
                HomeMealList("THE BEST", poster = state.upComing) {
                    onMealClick(it)
                }

            }
        }

    }
    if(state.isLoading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }

}