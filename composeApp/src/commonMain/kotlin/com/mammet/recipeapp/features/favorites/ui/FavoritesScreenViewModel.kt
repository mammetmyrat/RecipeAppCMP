package com.mammet.recipeapp.features.favorites.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mammet.recipeapp.features.favorites.domain.repositories.FavoriteRecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesScreenViewModel(
    private val favoriteRecipeRepository: FavoriteRecipeRepository
): ViewModel() {

    private var _favoritesUiState = MutableStateFlow(FavoritesScreenUiState())
    val favoritesUiState = _favoritesUiState.asStateFlow()


    suspend fun getFavoriteRecipeList(){
        val recipeListResult = favoriteRecipeRepository.getFavoriteRecipes()
        if (recipeListResult.isSuccess){
            _favoritesUiState.value = _favoritesUiState.value.copy(
                itemList = recipeListResult.getOrDefault(emptyList()),
                itemListIsLoading = false,
            )
        }else{
            _favoritesUiState.update {
                it.copy(
                    itemListError = recipeListResult.exceptionOrNull()?.message,
                    itemListIsLoading = false,
                )
            }
        }
    }
}