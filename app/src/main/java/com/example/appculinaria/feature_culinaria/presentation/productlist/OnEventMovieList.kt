package com.example.appculinaria.feature_culinaria.presentation.productlist

sealed class OnEventMovieList {
    data class OnMealClick(val mealId:String):OnEventMovieList()
}