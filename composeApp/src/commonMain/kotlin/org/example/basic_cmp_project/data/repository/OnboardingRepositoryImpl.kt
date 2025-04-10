package org.example.basic_cmp_project.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.basic_cmp_project.data.dataStore.OnboardingDataStore
import org.example.basic_cmp_project.domain.repository.OnboardingRepository

class OnboardingRepositoryImpl(
    private val dataStore: OnboardingDataStore
): OnboardingRepository {
    override fun getOnboardingShown(): Flow<Boolean> {
        return dataStore.getOnboardingShown()
    }

    override suspend fun setOnboardingShown(isShown: Boolean) {
        return dataStore.setOnboardingShown(isShown)
    }
}