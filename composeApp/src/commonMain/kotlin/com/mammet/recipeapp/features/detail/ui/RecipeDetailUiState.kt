package com.mammet.recipeapp.features.detail.ui

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

data class RecipeDetailUiState(
    val recipeDetail: RecipeItem? = null,
    val recipeDetailIsLoading: Boolean = true,
    val recipeDetailError: String? = null,
)
