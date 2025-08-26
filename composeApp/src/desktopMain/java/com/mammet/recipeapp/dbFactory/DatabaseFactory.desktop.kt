package com.mammet.recipeapp.dbFactory

import app.cash.sqldelight.async.coroutines.awaitCreate
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.mammet.recipeapp.RecipeAppDB
import java.util.Properties

actual class DatabaseFactory {
    actual suspend fun createDriver(): SqlDriver {
        val driver = JdbcSqliteDriver(
            JdbcSqliteDriver.IN_MEMORY,
            properties = Properties().apply { put("foreign_keys","true") }
        )
        driver.execute(null, "PRAGMA foreign_keys=ON;", 0)
        RecipeAppDB.Schema.awaitCreate(driver)
        return driver
    }
}