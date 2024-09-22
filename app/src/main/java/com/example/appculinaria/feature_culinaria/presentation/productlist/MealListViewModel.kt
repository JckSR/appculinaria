package com.example.appculinaria.feature_culinaria.presentation.productlist


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appculinaria.feature_culinaria.domain.repository.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealListViewModel @Inject constructor(private val repository: MealRepository):ViewModel() {


    var state by mutableStateOf(MealListState())
        private set

    init {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            val upComing = launch { getUpComing() }
            listOf(upComing).forEach { it.join() }
            state = state.copy(
                isLoading = false
            )
        }
    }

    private suspend fun getUpComing(){
        repository.getAllMeal().collect{
            it.onSuccess { listUpcoming->
                if (listUpcoming.isNotEmpty()){
                    state = state.copy(
                        upComing = listUpcoming
                    )
                }
            }.onFailure {
                println()
            }
        }
    }


}