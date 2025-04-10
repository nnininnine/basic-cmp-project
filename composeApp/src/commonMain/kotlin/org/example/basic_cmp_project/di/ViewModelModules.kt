package org.example.basic_cmp_project.di

import androidx.lifecycle.SavedStateHandle
import org.example.basic_cmp_project.feature.home.presentation.HomeViewModel
import org.example.basic_cmp_project.feature.welcome.presentation.WelcomeViewModel
import org.koin.core.module.dsl.viewModelOf

import org.koin.dsl.module

val viewModelModules = module {
    single<SavedStateHandle> { SavedStateHandle() }

    viewModelOf(::HomeViewModel)
    viewModelOf(::WelcomeViewModel)
}