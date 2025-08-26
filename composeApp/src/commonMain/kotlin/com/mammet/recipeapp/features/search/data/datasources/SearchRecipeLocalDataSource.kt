package com.mammet.recipeapp.features.search.data.datasources

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

interface SearchRecipeLocalDataSource {
    suspend fun searchRecipesByText(query: String): List<RecipeItem>
}