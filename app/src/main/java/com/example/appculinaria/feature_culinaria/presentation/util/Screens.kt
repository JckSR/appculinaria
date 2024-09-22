package com.example.appculinaria.feature_culinaria.presentation.util


sealed class Screens(val route: String) {
    object MealListScreen:Screens("meal_list")
    object DetailScreen : Screens("DETAIL/{meal_id]")
}