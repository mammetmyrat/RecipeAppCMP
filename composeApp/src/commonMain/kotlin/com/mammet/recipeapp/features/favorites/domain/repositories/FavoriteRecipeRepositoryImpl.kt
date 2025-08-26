package com.mammet.recipeapp.features.favorites.domain.repositories

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem
import com.mammet.recipeapp.features.favorites.datasources.FavoriteRecipeLocalDataSource

class FavoriteRecipeRepositoryImpl(
    private val favoriteRecipeLocalDataSource: FavoriteRecipeLocalDataSource,
): FavoriteRecipeRepository {
     override suspend fun getFavoriteRecipes(): Result<List<RecipeItem>>{
         return try {
             val favoriteRecipes = favoriteRecipeLocalDataSource.getFavoriteRecipes()
             return Result.success(favoriteRecipes)
         }catch (e: Exception){
                Result.failure(e)
         }
     }

    override suspend fun addFavorite(recipeId: Long){
        return favoriteRecipeLocalDataSource.addFavorite(recipeId)
    }
    override suspend fun removeFavorite(recipeId: Long){
        return favoriteRecipeLocalDataSource.removeFavorite(recipeId)
    }
}