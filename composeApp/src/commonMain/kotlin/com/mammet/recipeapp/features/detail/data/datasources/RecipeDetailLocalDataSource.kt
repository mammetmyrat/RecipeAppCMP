package com.mammet.recipeapp.features.detail.data.datasources

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

interface RecipeDetailLocalDataSource {

    suspend fun getRecipeDetail(id: Long): RecipeItem?

    suspend fun saveRecipeDetail(recipe: RecipeItem)

    suspend fun addFavorite(id: Long)
    suspend fun removeFavorite(id: Long)
    suspend fun isFavorite(id: Long): Boolean
}