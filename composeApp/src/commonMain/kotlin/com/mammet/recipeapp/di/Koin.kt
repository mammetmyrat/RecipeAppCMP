package com.mammet.recipeapp.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import kotlin.collections.plus

fun initKoin(
    additionModule: List<Module> = emptyList(),
    appDeclaration: KoinAppDeclaration = {}
) = startKoin{
    appDeclaration()
    modules(additionModule + cacheModule() + dataModule() + networkModule() + viewModelModule())
}