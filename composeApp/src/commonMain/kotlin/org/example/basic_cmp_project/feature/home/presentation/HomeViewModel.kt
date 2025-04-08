package org.example.basic_cmp_project.feature.home.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    fun toggleShowContent() {
        _uiState.value = UiState(showContent = !_uiState.value.showContent)
    }

    data class UiState(
        val showContent: Boolean = false
    )
}