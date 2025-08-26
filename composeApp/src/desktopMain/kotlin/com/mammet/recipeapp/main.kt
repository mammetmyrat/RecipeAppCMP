package com.mammet.recipeapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.mammet.recipeapp.di.initKoinJvm

val koin = initKoinJvm()
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "RecipeAppCMP",
    ) {
        App()
    }
}