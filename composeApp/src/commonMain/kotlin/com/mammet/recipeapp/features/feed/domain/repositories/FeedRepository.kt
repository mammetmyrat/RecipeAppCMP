package com.mammet.recipeapp.features.feed.domain.repositories

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem

interface FeedRepository {

    suspend fun getRecipesList(): Result<List<RecipeItem>>
}