package org.example.basic_cmp_project.domain.repository

import kotlinx.coroutines.flow.Flow

interface OnboardingRepository {
    fun getOnboardingShown(): Flow<Boolean>
    suspend fun setOnboardingShown(isShown: Boolean)
}