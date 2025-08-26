package com.mammet.recipeapp.di

import com.mammet.recipeapp.features.detail.data.datasources.RecipeDetailLocalDataSource
import com.mammet.recipeapp.features.detail.data.datasources.RecipeDetailLocalDataSourceImpl
import com.mammet.recipeapp.features.detail.data.datasources.RecipeDetailRemoteDataSource
import com.mammet.recipeapp.features.detail.data.datasources.RecipeDetailRemoteDataSourceImpl
import com.mammet.recipeapp.features.detail.data.repositories.RecipeDetailRepositoryImpl
import com.mammet.recipeapp.features.detail.domain.repositories.RecipeDetailRepository
import com.mammet.recipeapp.features.favorites.datasources.FavoriteRecipeLocalDataSource
import com.mammet.recipeapp.features.favorites.datasources.FavoriteRecipeLocalDataSourceImpl
import com.mammet.recipeapp.features.favorites.domain.repositories.FavoriteRecipeRepository
import com.mammet.recipeapp.features.favorites.domain.repositories.FavoriteRecipeRepositoryImpl
import com.mammet.recipeapp.features.feed.data.datasources.FeedLocalDataSource
import com.mammet.recipeapp.features.feed.data.datasources.FeedLocalDataSourceImpl
import com.mammet.recipeapp.features.feed.data.datasources.FeedRemoteDataSource
import com.mammet.recipeapp.features.feed.data.datasources.FeedRemoteDataSourceImpl
import com.mammet.recipeapp.features.feed.data.repositories.FeedRepositoryImpl
import com.mammet.recipeapp.features.feed.domain.repositories.FeedRepository
import com.mammet.recipeapp.features.search.data.datasources.SearchRecipeLocalDataSource
import com.mammet.recipeapp.features.search.data.datasources.SearchRecipeLocalDataSourceImpl
import com.mammet.recipeapp.features.search.data.repositories.SearchRecipeRepositoryImpl
import com.mammet.recipeapp.features.search.domain.repositories.SearchRecipeRepository
import com.mammet.recipeapp.preferences.AppPreferences
import com.mammet.recipeapp.preferences.AppPreferencesImpl
import org.koin.dsl.module

fun dataModule() = module {
    single<AppPreferences> { AppPreferencesImpl(get()) }

    single<FeedLocalDataSource> { FeedLocalDataSourceImpl(get()) }
    single<FeedRemoteDataSource> { FeedRemoteDataSourceImpl(get()) }

    single<RecipeDetailLocalDataSource> { RecipeDetailLocalDataSourceImpl(get(), get()) }
    single<RecipeDetailRemoteDataSource> { RecipeDetailRemoteDataSourceImpl(get()) }

    single<FavoriteRecipeLocalDataSource> { FavoriteRecipeLocalDataSourceImpl(get()) }

    single<SearchRecipeLocalDataSource> { SearchRecipeLocalDataSourceImpl(get()) }

    single<FeedRepository> { FeedRepositoryImpl(get(), get()) }
    single<RecipeDetailRepository> { RecipeDetailRepositoryImpl(get(), get()) }
    single<FavoriteRecipeRepository> { FavoriteRecipeRepositoryImpl(get()) }
    single<SearchRecipeRepository> { SearchRecipeRepositoryImpl(get()) }
}