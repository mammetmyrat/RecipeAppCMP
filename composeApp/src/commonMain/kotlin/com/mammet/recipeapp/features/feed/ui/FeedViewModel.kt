package com.mammet.recipeapp.features.feed.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mammet.recipeapp.features.feed.domain.repositories.FeedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FeedViewModel(
    private val feedRepository: FeedRepository
): ViewModel() {

    private var _feedUIState = MutableStateFlow(FeedUiState())
    val feedUIState = _feedUIState.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.Default) {
            getRecipeList()
        }

    }

    private suspend fun getRecipeList(){
        val recipeListResult = feedRepository.getRecipesList()
        if (recipeListResult.isSuccess){
            _feedUIState.value = _feedUIState.value.copy(
                recipesList = recipeListResult.getOrDefault(emptyList()),
                recipesIsLoading = false,
            )
        }else{
            _feedUIState.update {
                it.copy(
                    recipesListError = recipeListResult.exceptionOrNull()?.message,
                    recipesIsLoading = false,
                )
            }
        }
    }
}