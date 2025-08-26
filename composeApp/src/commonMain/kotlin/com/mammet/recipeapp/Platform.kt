package com.mammet.recipeapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform