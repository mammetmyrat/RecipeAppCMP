package com.mammet.recipeapp.features.feed.data.datasources

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem


interface FeedRemoteDataSource {

    suspend fun getRecipeList(): List<RecipeItem>
}