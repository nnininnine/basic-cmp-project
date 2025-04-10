package org.example.basic_cmp_project.domain.useCase

import org.example.basic_cmp_project.domain.repository.OnboardingRepository

interface SetOnboardingShownUseCase {
    suspend fun execute(isShown: Boolean)
}

class SetOnboardingShownUseCaseImpl(
    private val repository: OnboardingRepository
): SetOnboardingShownUseCase {
    override suspend fun execute(isShown: Boolean) {
        return repository.setOnboardingShown(isShown)
    }
}