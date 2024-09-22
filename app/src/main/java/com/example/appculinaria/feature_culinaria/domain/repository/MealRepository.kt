package com.example.appculinaria.feature_culinaria.domain.repository

import com.example.appculinaria.feature_culinaria.domain.model.Meal
import com.example.appculinaria.feature_culinaria.domain.model.MealDetail
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    fun getAllMeal():Flow<Result<List<Meal>>>
    suspend fun getMealById(id:String):Result<MealDetail>
}