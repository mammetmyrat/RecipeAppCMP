package com.mammet.recipeapp.features.search.domain.repositories

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

interface SearchRecipeRepository {
    suspend fun searchRecipesByText(query: String): Result<List<RecipeItem>>
}