package com.mammet.recipeapp.features.search.ui

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

data class SearchScreenState(
    val idle: Boolean = true,
    val success: Boolean = false,
    val error: String? = null,
    val results: List<RecipeItem> = emptyList()
)