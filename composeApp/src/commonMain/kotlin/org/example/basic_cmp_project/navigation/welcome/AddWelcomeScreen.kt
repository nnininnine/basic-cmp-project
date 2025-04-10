package org.example.basic_cmp_project.navigation.welcome

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch
import org.example.basic_cmp_project.domain.useCase.GetOnboardingShownUseCase
import org.example.basic_cmp_project.domain.useCase.SetOnboardingShownUseCase
import org.example.basic_cmp_project.feature.welcome.presentation.WelcomeScreen
import org.example.basic_cmp_project.navigation.MainScreen
import org.example.basic_cmp_project.navigation.RootScreen
import org.koin.compose.koinInject

fun NavGraphBuilder.addWelcomeScreen(navController: NavController) {
    composable(route = RootScreen.Welcome.route) {
        // inject GetOnboardingShownUseCase
        val getOnboardingShownUseCase = koinInject<GetOnboardingShownUseCase>()
        val setOnboardingShownUseCase = koinInject<SetOnboardingShownUseCase>()
        val scope = rememberCoroutineScope()

        var isOnboardingShown by remember { mutableStateOf(false) }
        LaunchedEffect(Unit) {
            isOnboardingShown = getOnboardingShownUseCase.execute()
        }

        if (isOnboardingShown) {
            // bypass to main screen
            MainScreen {}
        } else {
            // show welcome screen
            WelcomeScreen(
                navigateToHome = {
                    scope.launch {
                        // set onboarding shown = true
                        setOnboardingShownUseCase.execute(true)
                        navController.navigate(route = RootScreen.Main.route)
                    }
                })
        }
    }
}