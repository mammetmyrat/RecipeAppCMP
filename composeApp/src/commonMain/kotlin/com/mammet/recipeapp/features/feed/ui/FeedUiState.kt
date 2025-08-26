package com.mammet.recipeapp.features.feed.ui

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

data class FeedUiState(
    val recipesList: List<RecipeItem>? = null,
    val recipesIsLoading: Boolean = true,
    val recipesListError: String? = null,

)
