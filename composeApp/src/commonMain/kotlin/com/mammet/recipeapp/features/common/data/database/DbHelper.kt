package com.mammet.recipeapp.features.common.data.database

import com.mammet.recipeapp.Recipe
import com.mammet.recipeapp.RecipeAppDB
import com.mammet.recipeapp.dbFactory.DatabaseFactory
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DbHelper(
    private val driverFactory: DatabaseFactory
){
    private var db: RecipeAppDB? = null
    private val mutex = Mutex()

    suspend fun <Result: Any?> withDatabase(block: suspend (RecipeAppDB)-> Result) = mutex.withLock {
        if (db == null){
            db = createDb(driverFactory)
        }
        return@withLock block(db ?: throw IllegalStateException("Database not initialized"))
    }

    private suspend fun createDb(driverFactory: DatabaseFactory): RecipeAppDB{
        return RecipeAppDB(driver = driverFactory.createDriver(), RecipeAdapter = Recipe.Adapter(
            ingredientsAdapter = listOfStringsAdapter,
            instructionsAdapter = listOfStringsAdapter,
        ))
    }
}