package com.mammet.recipeapp

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mammet.recipeapp.features.app.data.rememberAppState
import com.mammet.recipeapp.features.app.navigation.AppNavHost
import com.mammet.recipeapp.features.designSystem.theme.RecipeAppTheme
import com.mammet.recipeapp.features.login.ui.LoginScreenModalBottomSheet
import com.mammet.recipeapp.features.login.ui.LoginViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(
    loginViewModel: LoginViewModel = koinViewModel(),
    navController: NavHostController = rememberNavController()

) {
    RecipeAppTheme {
        KoinContext {
            val appState = rememberAppState(
                navController = navController,
                scope = rememberCoroutineScope(),
                appPreferences = koinInject()
            )
            var showLoginBottomSheet by remember {
                mutableStateOf(false )
            }
            val isLoggedIn by appState.isLoggedIn.collectAsState()

            val isUserLoggedIn: () -> Boolean = {
                isLoggedIn
            }

            var loginCallback : () -> Unit by remember {
                mutableStateOf({})
            }
            val openLoginBottomSheet: (() -> Unit) -> Unit = { laterCallback ->
                showLoginBottomSheet = true
                loginCallback = laterCallback
            }
            val onLoginSuccess: () -> Unit = {
                println("onLoginSuccess")
                showLoginBottomSheet = false
                appState.updateIsLoggedIn(true)
                loginViewModel.resetState()
                loginCallback()
            }

            val onLogout: () -> Unit = {
                appState.onLogout()
                loginViewModel.resetState()
            }

            val onCloseSheet: () -> Unit = {
                showLoginBottomSheet = false
                loginViewModel.resetState()
            }
            LoginScreenModalBottomSheet(
                loginViewModel = loginViewModel,
                showBottomSheet = showLoginBottomSheet,
                onClose = onCloseSheet,
                onLoginSuccess = onLoginSuccess,
            )
            AppNavHost(
                appState = appState,
                isUserLoggedIn = isUserLoggedIn,
                openLoginBottomSheet = openLoginBottomSheet,
                onLogout = onLogout,
            )
        }
    }
}