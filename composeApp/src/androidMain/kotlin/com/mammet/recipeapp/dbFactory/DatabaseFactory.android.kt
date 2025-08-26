package com.mammet.recipeapp.dbFactory

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.mammet.recipeapp.RecipeAppDB

actual class DatabaseFactory(
    private val context: Context
) {
    actual suspend fun createDriver(): SqlDriver {
        val schema = RecipeAppDB.Schema.synchronous()
       return AndroidSqliteDriver(
           schema,
           context,
           DB_FILE_NAME,
           callback = object : AndroidSqliteDriver.Callback(schema){
               override fun onOpen(db: SupportSQLiteDatabase) {
                   db.setForeignKeyConstraintsEnabled(true)
               }
           }
       )
    }
}