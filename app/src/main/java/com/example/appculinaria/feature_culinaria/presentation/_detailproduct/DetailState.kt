package com.example.appculinaria.feature_culinaria.presentation._detailproduct

import com.example.appculinaria.feature_culinaria.domain.model.MealDetail

data class DetailState(
    val meal:MealDetail? = null,
    val isLoading:Boolean = false
)
