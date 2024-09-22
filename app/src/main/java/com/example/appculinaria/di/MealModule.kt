package com.example.appculinaria.di

import android.app.Application
import androidx.room.Room
import com.example.appculinaria.feature_culinaria.data.data_source.local.MealDao
import com.example.appculinaria.feature_culinaria.data.data_source.local.MealDatabase
import com.example.appculinaria.feature_culinaria.data.data_source.remote.MealApi
import com.example.appculinaria.feature_culinaria.data.repository.MealRepositoryImpl
import com.example.appculinaria.feature_culinaria.domain.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MealModule {
    @Provides
    @Singleton
    fun provideMealRepository(db:MealDatabase,api:MealApi):MealRepository{
        return MealRepositoryImpl(db.dao(),api)
    }

    @Provides
    @Singleton
    fun provideDataBase(app:Application):MealDatabase{
        return Room.databaseBuilder(
            app,
            MealDatabase::class.java,
            "meal_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDatabaseDao(database: MealDatabase):MealDao{
        return database.dao()
    }

    @Provides
    @Singleton
    fun provideMealApi():MealApi{
        return Retrofit.Builder()
            .baseUrl(MealApi.API_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(MealApi::class.java)
    }

}