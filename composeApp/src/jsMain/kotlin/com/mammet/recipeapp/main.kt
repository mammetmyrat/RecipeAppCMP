package com.mammet.recipeapp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.mammet.recipeapp.di.initKoinJs
import kotlinx.browser.document

val koin = initKoinJs()

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        App()
    }
}