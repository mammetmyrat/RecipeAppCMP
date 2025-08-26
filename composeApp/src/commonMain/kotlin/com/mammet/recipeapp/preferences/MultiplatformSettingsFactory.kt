package com.mammet.recipeapp.preferences

import com.russhwolf.settings.Settings

expect class MultiplatformSettingsFactory {
    fun getSettings(): Settings
}