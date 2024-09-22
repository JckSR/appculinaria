package com.example.appculinaria.feature_culinaria.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appculinaria.feature_culinaria.data.data_source.local.entity.MealEntity

@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCulinaria(culinariaEntity:MealEntity)

    @Query("SELECT * FROM MealEntity")
    suspend fun getCulinarias():List<MealEntity>
}