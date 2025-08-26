package com.mammet.recipeapp.features.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mammet.recipeapp.features.app.data.Screen
import com.mammet.recipeapp.features.detail.ui.DetailRoute
import com.mammet.recipeapp.features.search.ui.SearchRoute

fun NavController.navigateToSearch(navOptions: NavOptions? = null) {
    navigate(Screen.Search.route)
}

fun NavGraphBuilder.searchNavGraph(
    navigateToDetail: (Long) -> Unit,
    onBackClick: () -> Unit,
    ) {
    composable(Screen.Search.route) {
        SearchRoute(
            navigateToDetail = navigateToDetail,
            onBackPress = onBackClick,
        )
    }
}