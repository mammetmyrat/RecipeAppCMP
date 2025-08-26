package com.mammet.recipeapp.features.detail.data.datasources

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

interface RecipeDetailRemoteDataSource {

    suspend fun getRecipeDetail(id: Long): RecipeItem?
}