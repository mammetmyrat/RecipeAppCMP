package com.mammet.recipeapp.features.feed.data.datasources

import com.mammet.recipeapp.features.common.data.database.daos.RecipeDao
import com.mammet.recipeapp.features.common.domain.entities.RecipeItem


class FeedLocalDataSourceImpl(
    private val recipeDao: RecipeDao
): FeedLocalDataSource {

    override suspend fun getRecipeList(): List<RecipeItem>{
        return recipeDao.getAllRecipes()
    }

    override suspend fun saveRecipeList(recipes: List<RecipeItem>) {
        recipeDao.insertRecipesBulk(recipes)
    }
}