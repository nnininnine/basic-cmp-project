package org.example.basic_cmp_project.di

import org.example.basic_cmp_project.data.dataStore.OnboardingDataStore
import org.example.basic_cmp_project.data.dataStore.OnboardingDataStoreImpl
import org.example.basic_cmp_project.data.dataStore.PrefsDataStore
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataStoreModules = module {
    singleOf<OnboardingDataStore, PrefsDataStore>(::OnboardingDataStoreImpl)
}