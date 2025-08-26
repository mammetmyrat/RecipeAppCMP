package com.mammet.recipeapp.features.detail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mammet.recipeapp.features.detail.domain.repositories.RecipeDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeDetailViewModel(
    private val recipeDetailRepository: RecipeDetailRepository
): ViewModel() {

    private var _detailUiState = MutableStateFlow(RecipeDetailUiState())
    val detailUiState = _detailUiState.asStateFlow()

    private var _updateIsFavUiState = MutableStateFlow(RecipeDetailUpdateIsFavUiState())
    val updateIsFavUiState = _updateIsFavUiState.asStateFlow()


    fun getRecipeDetail(id: Long){
        viewModelScope.launch(Dispatchers.Default){
            val recipeDetailRes = recipeDetailRepository.getRecipeDetail(id)
            if (recipeDetailRes.isSuccess){
                _detailUiState.value = _detailUiState.value.copy(
                    recipeDetail = recipeDetailRes.getOrNull(),
                    recipeDetailIsLoading = false,
                )
            }else{
                _detailUiState.value = _detailUiState.value.copy(
                    recipeDetailError = recipeDetailRes.exceptionOrNull()?.message,
                    recipeDetailIsLoading = false,
                )
            }

        }
    }
    fun updateIsFavorite(recipeId: Long, isAdding: Boolean) {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                _updateIsFavUiState.value = _updateIsFavUiState.value.copy(isUpdating = true)

                if (isAdding) {
                    recipeDetailRepository.addFavorite(recipeId)
                } else {
                    recipeDetailRepository.removeFavorite(recipeId)
                }

                //refresh detail
                _detailUiState.value = _detailUiState.value.copy(
                    recipeDetail = _detailUiState.value.recipeDetail?.copy(isFavorite = isAdding)
                )
                _updateIsFavUiState.value =
                    _updateIsFavUiState.value.copy(isSuccess = true, isUpdating = false)

            } catch (e: Exception) {
                _updateIsFavUiState.value =
                    _updateIsFavUiState.value.copy(error = e.message, isUpdating = false)
            }
        }
    }
}