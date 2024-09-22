package com.example.appculinaria.feature_culinaria.presentation._detailproduct.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appculinaria.feature_culinaria.domain.repository.MealRepository
import com.example.appculinaria.feature_culinaria.presentation._detailproduct.DetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository :MealRepository
):ViewModel() {
    var state by mutableStateOf(DetailState())
        private  set

    init{
        state = state.copy(
            isLoading = true
        )
        val movieId = savedStateHandle.get<String>("meal_list")
        movieId?.let {
            viewModelScope.launch {
                repository.getMealById(movieId).onSuccess {
                    state =state.copy(
                        meal = it
                    )
                }.onFailure {
                    println()
                }
                state = state.copy(
                    isLoading = false
                )
            }
        }?:kotlin.run {
            println("the meal id is null")
        }
    }
}