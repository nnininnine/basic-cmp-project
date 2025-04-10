package org.example.basic_cmp_project.di

import org.example.basic_cmp_project.domain.repository.OnboardingRepository
import org.example.basic_cmp_project.domain.useCase.GetOnboardingShownUseCase
import org.example.basic_cmp_project.domain.useCase.GetOnboardingShownUseCaseImpl
import org.example.basic_cmp_project.domain.useCase.SetOnboardingShownUseCase
import org.example.basic_cmp_project.domain.useCase.SetOnboardingShownUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModules = module {
    singleOf<GetOnboardingShownUseCase, OnboardingRepository>(::GetOnboardingShownUseCaseImpl)
    singleOf<SetOnboardingShownUseCase, OnboardingRepository>(::SetOnboardingShownUseCaseImpl)
}