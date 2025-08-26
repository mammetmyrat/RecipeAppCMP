package com.mammet.recipeapp.features.feed.data.repositories

import com.mammet.recipeapp.features.common.domain.entities.RecipeItem
import com.mammet.recipeapp.features.feed.data.datasources.FeedLocalDataSource
import com.mammet.recipeapp.features.feed.data.datasources.FeedRemoteDataSource
import com.mammet.recipeapp.features.feed.domain.repositories.FeedRepository

class FeedRepositoryImpl(
    private val feedLocalDataSource: FeedLocalDataSource,
    private val feedRemoteDataSource: FeedRemoteDataSource
): FeedRepository {

      override suspend fun getRecipesList(): Result<List<RecipeItem>> {
          return try {
              val recipeListCache = feedLocalDataSource.getRecipeList()
              val count = recipeListCache.count()
             return if (count> 0){
                 Result.success(recipeListCache)
              }else{
                  val recipeListApiResponse = feedRemoteDataSource.getRecipeList()
                 feedLocalDataSource.saveRecipeList(recipeListApiResponse)
                 Result.success(recipeListApiResponse)
             }
          }catch (e: Exception){
              Result.failure(e)
          }
     }

}