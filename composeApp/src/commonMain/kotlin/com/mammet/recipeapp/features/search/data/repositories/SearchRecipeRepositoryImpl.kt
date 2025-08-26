package com.mammet.recipeapp.features.search.data.repositories

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem
import com.mammet.recipeapp.features.search.data.datasources.SearchRecipeLocalDataSource
import com.mammet.recipeapp.features.search.domain.repositories.SearchRecipeRepository

class SearchRecipeRepositoryImpl(
    private val searchRecipeLocalDataSource: SearchRecipeLocalDataSource
): SearchRecipeRepository {
    override suspend fun searchRecipesByText(query: String): Result<List<RecipeItem>> {
        return try {
            val resultList = searchRecipeLocalDataSource.searchRecipesByText(query)
            Result.success(resultList)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}