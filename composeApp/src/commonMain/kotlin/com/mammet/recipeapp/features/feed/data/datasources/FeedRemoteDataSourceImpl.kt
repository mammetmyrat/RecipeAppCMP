package com.mammet.recipeapp.features.feed.data.datasources

import com.mammet.recipeapp.features.common.data.api.BASE_URL
import com.mammet.recipeapp.features.common.data.models.RecipeListApiResponse
import com.mammet.recipeapp.features.common.data.models.toRecipe
import com.mammet.recipeapp.features.common.domain.entities.RecipeItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get


class FeedRemoteDataSourceImpl(
    private val httpClient: HttpClient
): FeedRemoteDataSource {

    override suspend fun getRecipeList(): List<RecipeItem>{
        val httpResponse = httpClient.get("${BASE_URL}search.php?f=b")
        val recipeListApiResponse = httpResponse.body<RecipeListApiResponse>()
        return recipeListApiResponse.meals.mapNotNull {it.toRecipe()}
    }
}