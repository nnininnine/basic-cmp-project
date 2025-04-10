package org.example.basic_cmp_project.domain.useCase

import kotlinx.coroutines.flow.first
import org.example.basic_cmp_project.domain.repository.OnboardingRepository

interface GetOnboardingShownUseCase {
    suspend fun execute(): Boolean
}

class GetOnboardingShownUseCaseImpl(
    private val repository: OnboardingRepository
): GetOnboardingShownUseCase {
    override suspend fun execute(): Boolean {
        return repository.getOnboardingShown().first()
    }
}