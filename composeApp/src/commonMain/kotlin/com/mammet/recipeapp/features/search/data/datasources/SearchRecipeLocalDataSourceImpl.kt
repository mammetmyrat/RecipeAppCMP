package com.mammet.recipeapp.features.search.data.datasources

import com.mammet.recipeapp.features.common.data.database.daos.RecipeDao
import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

class SearchRecipeLocalDataSourceImpl(
    private val recipeDao: RecipeDao
): SearchRecipeLocalDataSource {
    override suspend fun searchRecipesByText(query: String): List<RecipeItem> {
        return recipeDao.searchRecipesByText(query)
    }
}