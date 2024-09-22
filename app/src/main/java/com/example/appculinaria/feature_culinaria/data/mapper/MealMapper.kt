package com.example.appculinaria.feature_culinaria.data.mapper

import android.graphics.Movie
import com.example.appculinaria.feature_culinaria.data.data_source.local.entity.MealEntity
import com.example.appculinaria.feature_culinaria.data.data_source.remote.dto.MealDetailDto
import com.example.appculinaria.feature_culinaria.domain.model.Meal
import com.example.appculinaria.feature_culinaria.domain.model.MealDetail

fun MealDetailDto.toResult(): Meal{
    return Meal(
        id =idMeal ,
        poster =strMealThumb ,
        name =strMeal

    )
}

fun Meal.toEntity():MealEntity{
    return MealEntity(
        id = id,
        poster = poster,
        name = name
    )
}

fun MealEntity.toDomain():Meal{
    return Meal(
        id = id,
        poster = poster,
        name = name
    )
}

fun MealDetailDto.toDetail():MealDetail{
    return MealDetail(
        id = idMeal,
        image = strMealThumb,
        name =strMeal ,
        description =strInstructions ,
        linkYoutube =strYoutube ,
        linkPage =strSource
    )
}