package com.mammet.recipeapp.features.common.data.database.daos

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOne
import app.cash.sqldelight.async.coroutines.awaitAsOneOrNull
import com.mammet.recipeapp.features.common.data.database.DbHelper
import com.mammet.recipeapp.features.common.data.database.recipeEntityMapper
import com.mammet.recipeapp.features.common.domain.entities.RecipeItem
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class FavoriteRecipeDao(
    private val dbHelper: DbHelper
) {

    @OptIn(ExperimentalTime::class)
    suspend fun addFavorite(recipeId: Long) {
        val currentDateTime = "2002-04-12T12:00:00"
        dbHelper.withDatabase { database ->
            database.favoriteRecipeQueries.insertFavorite(
                added_at = currentDateTime.toString(),
                recipe_id = recipeId
            )
        }
    }

    suspend fun removeFavorite(recipeId: Long) {
        dbHelper.withDatabase { database ->
            database.favoriteRecipeQueries.detelteFavoriteByRecipeById(
                recipe_id = recipeId
            )
        }
    }

    suspend fun getAllFavoriteRecipes(): List<RecipeItem> {
        return dbHelper.withDatabase { database ->
            database.favoriteRecipeQueries.selectAllFavoriteRecipeIds().awaitAsList().map {
                recipeEntityMapper(it)
            }
        }
    }


    suspend fun isFavorite(recipeId: Long): Boolean {
        return dbHelper.withDatabase { database ->
            database.favoriteRecipeQueries.selectFavoriteByRecipeId(recipeId)
                .awaitAsOneOrNull() != null
        }
    }


}