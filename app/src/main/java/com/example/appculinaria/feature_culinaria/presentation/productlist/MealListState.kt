package com.example.appculinaria.feature_culinaria.presentation.productlist

import com.example.appculinaria.feature_culinaria.domain.model.Meal


data class MealListState(
    val upComing:List<Meal> = emptyList(),
    val isLoading:Boolean = true
)
