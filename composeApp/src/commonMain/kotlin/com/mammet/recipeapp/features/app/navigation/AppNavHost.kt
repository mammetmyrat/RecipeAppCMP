package com.mammet.recipeapp.features.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mammet.recipeapp.features.app.data.AppState
import com.mammet.recipeapp.features.app.data.Screen
import com.mammet.recipeapp.features.detail.navigation.detailNavGraph
import com.mammet.recipeapp.features.detail.navigation.navigateToDetail
import com.mammet.recipeapp.features.search.navigation.navigateToSearch
import com.mammet.recipeapp.features.search.navigation.searchNavGraph
import com.mammet.recipeapp.features.tabs.navigation.tabsNavGraph

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    appState: AppState,
    startDestination: String = Screen.Tabs.route,
    isUserLoggedIn: () -> Boolean,
    openLoginBottomSheet: (() -> Unit) -> Unit,
    onLogout: () -> Unit,
) {
    val navController = appState.navController
    val tabNavController = rememberNavController()

    NavHost(navController, startDestination = startDestination) {
        tabsNavGraph(
            tabNavController = tabNavController,
            navigateToDetail = {
                appState.navController.navigateToDetail(it)
            },
            navigateToSearch = {
                appState.navController.navigateToSearch()
            },
            isUserLoggedIn = isUserLoggedIn,
            openLoginBottomSheet = openLoginBottomSheet,
            onLogout = onLogout,
        )

        searchNavGraph(
            navigateToDetail = {
                appState.navController.navigateToDetail(it)
            },
            onBackClick = appState::navigateBack,
        )

        detailNavGraph(
            onBackClick = appState::navigateBack,
            isUserLoggedIn = isUserLoggedIn,
            openLoginBottomSheet = openLoginBottomSheet,
        )
    }
}