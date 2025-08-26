package com.mammet.recipeapp.di

import com.mammet.recipeapp.dbFactory.DatabaseFactory
import com.mammet.recipeapp.preferences.MultiplatformSettingsFactory
import org.koin.dsl.module

val jvmModules = module {
    single { DatabaseFactory() }
    single { MultiplatformSettingsFactory() }
}

fun initKoinJvm() = initKoin(additionModule = listOf(jvmModules))