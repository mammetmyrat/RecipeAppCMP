package com.mammet.recipeapp.features.favorites.datasources

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

interface FavoriteRecipeLocalDataSource {

    suspend fun getFavoriteRecipes(): List<RecipeItem>

    suspend fun addFavorite(recipeId: Long)
    suspend fun removeFavorite(recipeId: Long)
}