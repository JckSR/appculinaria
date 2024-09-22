package com.example.appculinaria.feature_culinaria.data.data_source.remote

import com.example.appculinaria.feature_culinaria.data.data_source.remote.dto.MealDetailDto
import com.example.appculinaria.feature_culinaria.data.data_source.remote.dto.MealDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MealApi {
    companion object{
        const val API_URL = "www.themealdb.com/api/json/v1/1/"
    }

    @GET("lookup.php?i={meal_id}")
    suspend fun getMealById(@Path("meal_id")mealId:String):MealDetailDto

    @GET("search.php?f=p")
    suspend fun getAllMeal():MealDto
}