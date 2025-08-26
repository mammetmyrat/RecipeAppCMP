package com.mammet.recipeapp.di

import com.mammet.recipeapp.features.common.data.database.DbHelper
import com.mammet.recipeapp.features.common.data.database.daos.FavoriteRecipeDao
import com.mammet.recipeapp.features.common.data.database.daos.RecipeDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

fun cacheModule() = module {
    single<CoroutineContext> { Dispatchers.Default }
    single { CoroutineScope(get()) }

    single { DbHelper(get()) }
    single { RecipeDao(get()) }
    single { FavoriteRecipeDao(get()) }

}