package com.mammet.recipeapp.features.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.savedstate.read
import com.mammet.recipeapp.features.app.data.Screen
import com.mammet.recipeapp.features.detail.ui.DetailRoute
import com.mammet.recipeapp.features.favorites.ui.FavoritesRoute


const val RECIPE_ID_ARG = "recipeId"

fun NavController.navigateToDetail(id: Long, navOptions: NavOptions? = null) {
    navigate(Screen.Detail.route.replace(
        "$RECIPE_ID_ARG={$RECIPE_ID_ARG}",
        "$RECIPE_ID_ARG=$id")
    )
}

fun NavGraphBuilder.detailNavGraph(
    onBackClick: () -> Unit,
    isUserLoggedIn: () -> Boolean,
    openLoginBottomSheet: (() -> Unit) -> Unit,
) {
    composable(
        Screen.Detail.route,
        arguments = listOf(
            navArgument(RECIPE_ID_ARG){
                type = NavType.LongType
            }
        )
    ) {
        val recipeId = it.arguments?.read { getLong(RECIPE_ID_ARG) } ?: 0
        DetailRoute(
            recipeId = recipeId,
            onBackClick = onBackClick,
            isUserLoggedIn = isUserLoggedIn,
            openLoginBottomSheet = openLoginBottomSheet,
        )
    }
}