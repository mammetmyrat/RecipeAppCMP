package com.mammet.recipeapp.features.favorites.domain.repositories

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

interface FavoriteRecipeRepository {
    suspend fun getFavoriteRecipes(): Result<List<RecipeItem>>

    suspend fun addFavorite(recipeId: Long)
    suspend fun removeFavorite(recipeId: Long)
}