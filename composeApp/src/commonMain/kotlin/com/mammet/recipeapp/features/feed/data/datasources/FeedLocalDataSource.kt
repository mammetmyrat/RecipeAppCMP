package com.mammet.recipeapp.features.feed.data.datasources

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem


interface FeedLocalDataSource {

    suspend fun getRecipeList(): List<RecipeItem>
    suspend fun saveRecipeList(recipes: List<RecipeItem>)
}