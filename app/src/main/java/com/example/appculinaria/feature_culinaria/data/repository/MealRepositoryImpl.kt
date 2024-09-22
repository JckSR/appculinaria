package com.example.appculinaria.feature_culinaria.data.repository

import coil.network.HttpException
import com.example.appculinaria.feature_culinaria.data.data_source.local.MealDao
import com.example.appculinaria.feature_culinaria.data.data_source.remote.MealApi
import com.example.appculinaria.feature_culinaria.data.mapper.toDetail
import com.example.appculinaria.feature_culinaria.data.mapper.toDomain
import com.example.appculinaria.feature_culinaria.data.mapper.toEntity
import com.example.appculinaria.feature_culinaria.data.mapper.toResult
import com.example.appculinaria.feature_culinaria.domain.model.Meal
import com.example.appculinaria.feature_culinaria.domain.model.MealDetail
import com.example.appculinaria.feature_culinaria.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

class MealRepositoryImpl(private val dao:MealDao,private val api: MealApi):MealRepository {
    override fun getAllMeal(): Flow<Result<List<Meal>>> = flow{
        val local = dao.getCulinarias()
        emit(Result.success(local.map { it.toDomain() }))

        try {
            val remoteAllComing = api.getAllMeal().meals
            val meals = remoteAllComing.map { it.toResult() }
            meals.forEach{dao.insertCulinaria(it.toEntity())}

        }catch (e:HttpException){
            emit(Result.failure(e))

        }catch (e:IOException){
            emit(Result.failure(e))

        }
        val getUpComing = dao.getCulinarias().map { it.toDomain() }
        emit(Result.success(getUpComing))
    }

    override suspend fun getMealById(id: String): Result<MealDetail> {
        return  try {
            Result.success(api.getMealById(id).toDetail())
        }catch (e:HttpException){
            Result.failure(e)
        }catch (e:IOException){
            Result.failure(e)
        }
    }

}