package org.example.basic_cmp_project.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(koinModules)
    }
}