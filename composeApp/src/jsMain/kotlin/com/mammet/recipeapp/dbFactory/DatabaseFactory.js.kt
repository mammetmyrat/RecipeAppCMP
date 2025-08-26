package com.mammet.recipeapp.dbFactory

import app.cash.sqldelight.async.coroutines.awaitCreate
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import com.mammet.recipeapp.RecipeAppDB

actual class DatabaseFactory {
    actual suspend fun createDriver(): SqlDriver {
        val driver = WebWorkerDriver(
            _root_ide_package_.app.cash.sqldelight.driver.worker.expected.Worker(
                js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
            )
        )
        RecipeAppDB.Schema.awaitCreate(driver)
        return driver
    }
}