package com.mammet.recipeapp.features.favorites.datasources

import com.mammet.recipeapp.features.common.data.database.daos.FavoriteRecipeDao
import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

class FavoriteRecipeLocalDataSourceImpl(
    private val favoriteRecipeDao: FavoriteRecipeDao
): FavoriteRecipeLocalDataSource {
    override suspend fun getFavoriteRecipes(): List<RecipeItem> {
        return favoriteRecipeDao.getAllFavoriteRecipes()
    }

    override suspend fun addFavorite(recipeId: Long) {
        return favoriteRecipeDao.addFavorite(recipeId)
    }

    override suspend fun removeFavorite(recipeId: Long) {
        return favoriteRecipeDao.removeFavorite(recipeId)
    }
}