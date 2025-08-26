package com.mammet.recipeapp.di

import com.mammet.recipeapp.dbFactory.DatabaseFactory
import com.mammet.recipeapp.preferences.MultiplatformSettingsFactory
import org.koin.dsl.module

val jsModules = module {
    single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }
}

fun initKoinJs() = initKoin(additionModule = listOf(jsModules))