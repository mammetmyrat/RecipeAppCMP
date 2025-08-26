package com.mammet.recipeapp.features.favorites.ui

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

data class FavoritesScreenUiState(
    val itemList: List<RecipeItem>? = null,
    val itemListIsLoading: Boolean = true,
    val itemListError: String? = null,
)