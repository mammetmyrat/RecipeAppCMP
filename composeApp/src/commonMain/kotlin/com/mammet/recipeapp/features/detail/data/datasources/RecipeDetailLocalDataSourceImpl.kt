package com.mammet.recipeapp.features.detail.data.datasources

import com.mammet.recipeapp.features.common.data.database.daos.FavoriteRecipeDao
import com.mammet.recipeapp.features.common.data.database.daos.RecipeDao
import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

class RecipeDetailLocalDataSourceImpl(
    private val recipeDao: RecipeDao,
    private val favoriteRecipeDao: FavoriteRecipeDao,
): RecipeDetailLocalDataSource {
    override suspend fun getRecipeDetail(id: Long): RecipeItem? {
        return recipeDao.getRecipeById(id)
    }

    override suspend fun saveRecipeDetail(recipe: RecipeItem) {
        recipeDao.insertRecipe(recipe)
    }

    override suspend fun addFavorite(id: Long) {
        favoriteRecipeDao.addFavorite(id)
    }

    override suspend fun removeFavorite(id: Long) {
        favoriteRecipeDao.removeFavorite(id)
    }

    override suspend fun isFavorite(id: Long): Boolean {
        return favoriteRecipeDao.isFavorite(id)
    }
}