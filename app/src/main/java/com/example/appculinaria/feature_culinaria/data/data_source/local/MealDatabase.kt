package com.example.appculinaria.feature_culinaria.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appculinaria.feature_culinaria.data.data_source.local.entity.MealEntity

@Database(entities = [MealEntity::class], version = 1)
abstract class MealDatabase:RoomDatabase() {
    abstract fun dao():MealDao
}