package com.mammet.recipeapp.di

import com.mammet.recipeapp.features.detail.ui.RecipeDetailViewModel
import com.mammet.recipeapp.features.favorites.ui.FavoritesScreenViewModel
import com.mammet.recipeapp.features.feed.ui.FeedViewModel
import com.mammet.recipeapp.features.login.ui.LoginViewModel
import com.mammet.recipeapp.features.profile.ui.ProfileViewModel
import com.mammet.recipeapp.features.search.ui.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {

    viewModel {
        FeedViewModel(get())
    }

    viewModel {
        RecipeDetailViewModel(get())
    }

    viewModel {
        FavoritesScreenViewModel(get())
    }

    viewModel {
        ProfileViewModel()
    }

    viewModel {
        LoginViewModel()
    }

    viewModel {
        SearchViewModel(get())
    }

}