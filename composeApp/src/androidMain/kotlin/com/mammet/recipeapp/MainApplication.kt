package com.mammet.recipeapp

import android.app.Application
import com.mammet.recipeapp.dbFactory.DatabaseFactory
import com.mammet.recipeapp.di.initKoin
import com.mammet.recipeapp.preferences.MultiplatformSettingsFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class MainApplication: Application() {

    private val androidModules = module {
        single { DatabaseFactory(applicationContext) }
        single { MultiplatformSettingsFactory(applicationContext) }
    }

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        initKoin(
            additionModule = listOf(androidModules)
        ) {
            androidContext(applicationContext)

        }
    }
}