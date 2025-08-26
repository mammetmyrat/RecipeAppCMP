package com.mammet.recipeapp

import com.mammet.recipeapp.dbFactory.DatabaseFactory
import com.mammet.recipeapp.di.initKoin
import com.mammet.recipeapp.preferences.MultiplatformSettingsFactory
import org.koin.dsl.module

val iosModules = module {
    single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }
}

fun initKoinIOS() = initKoin(additionModule = listOf(iosModules))