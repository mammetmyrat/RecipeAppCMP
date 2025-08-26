package com.mammet.recipeapp.features.detail.data.repositories

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem
import com.mammet.recipeapp.features.detail.data.datasources.RecipeDetailLocalDataSource
import com.mammet.recipeapp.features.detail.data.datasources.RecipeDetailRemoteDataSource
import com.mammet.recipeapp.features.detail.domain.repositories.RecipeDetailRepository

class RecipeDetailRepositoryImpl(
    private val recipeDetailLocalDataStore: RecipeDetailLocalDataSource,
    private val recipeDetailRemoteDataStore: RecipeDetailRemoteDataSource,
) : RecipeDetailRepository {
    override suspend fun getRecipeDetail(id: Long): Result<RecipeItem> {
        return try {
            val localRecipe = recipeDetailLocalDataStore.getRecipeDetail(id)
            return if (localRecipe != null) {
                val isFav = recipeDetailLocalDataStore.isFavorite(id)
                 Result.success(localRecipe.copy(
                     isFavorite = isFav
                 ))
            } else {
                val remoteRecipe = recipeDetailRemoteDataStore.getRecipeDetail(id)
                    ?: return Result.failure(Exception("Recipe not found"))
                recipeDetailLocalDataStore.saveRecipeDetail(remoteRecipe)
                Result.success(remoteRecipe)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    override suspend fun addFavorite(id: Long) {
        recipeDetailLocalDataStore.addFavorite(id)
    }

    override suspend fun removeFavorite(id: Long) {
        recipeDetailLocalDataStore.removeFavorite(id)
    }
}