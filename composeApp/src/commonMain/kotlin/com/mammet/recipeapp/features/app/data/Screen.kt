package com.mammet.recipeapp.features.app.data

import com.mammet.recipeapp.features.detail.navigation.RECIPE_ID_ARG
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import recipeappcmp.composeapp.generated.resources.Res
import recipeappcmp.composeapp.generated.resources.bookmark_selected
import recipeappcmp.composeapp.generated.resources.bookmark_unselected
import recipeappcmp.composeapp.generated.resources.detail
import recipeappcmp.composeapp.generated.resources.favorites
import recipeappcmp.composeapp.generated.resources.home
import recipeappcmp.composeapp.generated.resources.home_selected
import recipeappcmp.composeapp.generated.resources.home_unselected
import recipeappcmp.composeapp.generated.resources.profile
import recipeappcmp.composeapp.generated.resources.profile_selected
import recipeappcmp.composeapp.generated.resources.profile_unselected
import recipeappcmp.composeapp.generated.resources.search
import recipeappcmp.composeapp.generated.resources.tabs

sealed class Screen(
    val route: String,
    val resourceId: StringResource,
    val selectedIcon: DrawableResource? = null,
    val unselectedIcon: DrawableResource? = null
) {

    data object Search: Screen("search", Res.string.search)
    data object Tabs: Screen("tabs", Res.string.tabs)
    data object Detail: Screen("detail?$RECIPE_ID_ARG={$RECIPE_ID_ARG}", Res.string.detail)

    data object Home: Screen(
        route = "home",
        resourceId = Res.string.home,
        selectedIcon = Res.drawable.home_selected,
        unselectedIcon = Res.drawable.home_unselected
    )

    data object Favorites: Screen(
        route = "favorites",
        resourceId = Res.string.favorites,
        selectedIcon = Res.drawable.bookmark_selected,
        unselectedIcon = Res.drawable.bookmark_unselected
    )
    data object Profile: Screen(
        route = "profile",
        resourceId = Res.string.profile,
        selectedIcon = Res.drawable.profile_selected,
        unselectedIcon = Res.drawable.profile_unselected
    )
}