package com.example.appculinaria.feature_culinaria.data.data_source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MealEntity(
    @PrimaryKey
    val id:String,
    val poster:String,
    val name: String

)
