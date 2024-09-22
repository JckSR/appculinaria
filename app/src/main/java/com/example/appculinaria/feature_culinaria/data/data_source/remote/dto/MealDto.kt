package com.example.appculinaria.feature_culinaria.data.data_source.remote.dto

import com.squareup.moshi.Json

data class MealDto(
    @field:Json(name = "meals")
    val meals: List<MealDetailDto>
)