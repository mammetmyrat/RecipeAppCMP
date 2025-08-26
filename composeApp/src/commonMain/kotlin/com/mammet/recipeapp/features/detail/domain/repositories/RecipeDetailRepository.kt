package com.mammet.recipeapp.features.detail.domain.repositories

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

interface RecipeDetailRepository {

    suspend fun getRecipeDetail(id: Long): Result<RecipeItem>
    suspend fun addFavorite(id: Long)
    suspend fun removeFavorite(id: Long)
}