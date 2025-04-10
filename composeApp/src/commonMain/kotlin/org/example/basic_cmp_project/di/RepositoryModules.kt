package org.example.basic_cmp_project.di

import org.example.basic_cmp_project.data.dataStore.OnboardingDataStore
import org.example.basic_cmp_project.data.repository.OnboardingRepositoryImpl
import org.example.basic_cmp_project.domain.repository.OnboardingRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModules = module {
    singleOf<OnboardingRepository, OnboardingDataStore>(::OnboardingRepositoryImpl)
}