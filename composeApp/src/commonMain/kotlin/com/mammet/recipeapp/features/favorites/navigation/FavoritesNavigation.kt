package com.mammet.recipeapp.features.favorites.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mammet.recipeapp.features.app.data.Screen
import com.mammet.recipeapp.features.favorites.ui.FavoritesRoute

fun NavController.navigateToFavorites(navOptions: NavOptions? = null) {
    navigate(Screen.Favorites.route)
}

fun NavGraphBuilder.favoritesNavGraph(
    navigateToDetail: (Long) -> Unit,
    isUserLoggedIn: () -> Boolean,
) {
    composable(Screen.Favorites.route) {
        FavoritesRoute(
            navigateToDetail = navigateToDetail,
            isUserLoggedIn = isUserLoggedIn,
        )
    }
}