package org.example.basic_cmp_project.feature.welcome.presentation

import androidx.compose.foundation.pager.PagerState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WelcomeViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow(UiState(PagerState(currentPage = 0, pageCount = { pageSize })))
    val uiState = _uiState.asStateFlow()

    val pageSize = 5

    suspend fun nextIndex() {
        // scroll to next page
        _uiState.value.pagerState.animateScrollToPage(uiState.value.pagerState.currentPage + 1)
    }

    data class UiState(
        val pagerState: PagerState,
    )
}