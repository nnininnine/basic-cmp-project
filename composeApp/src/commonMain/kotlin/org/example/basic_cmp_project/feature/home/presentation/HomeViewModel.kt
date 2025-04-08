package org.example.basic_cmp_project.feature.home.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val state: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState(showContent = state.get<Boolean>("showContent") ?: false))
    val uiState = _uiState.asStateFlow()

    fun toggleShowContent() {
        state["showContent"] = !_uiState.value.showContent
        _uiState.update { it.copy(showContent = !it.showContent) }
    }

    data class UiState(
        val showContent: Boolean = false,
    )
}