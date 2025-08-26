package com.mammet.recipeapp.features.feed.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mammet.recipeapp.features.app.data.Screen
import com.mammet.recipeapp.features.feed.ui.FeedRoute

fun NavController.navigateToFeed(navOptions: NavOptions? = null) {
    navigate(Screen.Home.route)
}

fun NavGraphBuilder.feedNavGraph(
    navigateToDetail: (Long) -> Unit,
    navigateToSearch: () -> Unit,
){
    composable(Screen.Home.route) {
        FeedRoute(
            navigateToSearch = navigateToSearch,
            navigateToDetail = navigateToDetail,
        )
    }
}