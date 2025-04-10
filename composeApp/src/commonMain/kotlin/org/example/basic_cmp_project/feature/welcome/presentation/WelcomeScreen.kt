package org.example.basic_cmp_project.feature.welcome.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun WelcomeScreen(
    navigateToHome: () -> Unit,
) {
    val vm = koinViewModel<WelcomeViewModel>()
    val uiState by vm.uiState.collectAsState()
    val scope = rememberCoroutineScope()

    Box {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(), state = uiState.pagerState
        ) { page ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Onboarding page: $page",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(bottom = 12.dp)
            ) {
                repeat(vm.pageSize) { index ->
                    val color =
                        if (uiState.pagerState.currentPage == index) Color.Red else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .clip(CircleShape)
                            .size(8.dp)
                            .background(color)
                    )
                }
            }
            Button(onClick = {
                if (uiState.pagerState.currentPage + 1 < vm.pageSize) {
                    // next
                    scope.launch {
                        vm.nextIndex()
                    }
                } else {
                    // done onboarding continue to main screen
                    navigateToHome()
                }

            }) {
                Text(if (uiState.pagerState.currentPage + 1 < vm.pageSize) "Next" else "Get started")
            }
        }
    }
}