package org.example.basic_cmp_project.data.dataStore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

interface OnboardingDataStore {
    fun getOnboardingShown(): Flow<Boolean>
    suspend fun setOnboardingShown(isShown: Boolean)
}

class OnboardingDataStoreImpl(
    private val prefsDataStore: PrefsDataStore,
) : OnboardingDataStore {
    companion object {
        private const val ONBOARDING_SHOWN_KEY = "onboardingShown"
    }

    override fun getOnboardingShown(): Flow<Boolean> {
        return prefsDataStore.data.map {
            return@map it[booleanPreferencesKey(ONBOARDING_SHOWN_KEY)] ?: false
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun setOnboardingShown(isShown: Boolean) {
        return withContext(Dispatchers.IO) {
            try {
                prefsDataStore.edit {
                    it[booleanPreferencesKey(ONBOARDING_SHOWN_KEY)] = isShown
                }
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                e.printStackTrace()
            }
        }
    }
}