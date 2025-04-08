package org.example.basic_cmp_project.navigation.welcome

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.example.basic_cmp_project.feature.welcome.presentation.WelcomeScreen
import org.example.basic_cmp_project.navigation.RootScreen

fun NavGraphBuilder.addWelcomeScreen(navController: NavController) {
    composable(route = RootScreen.Welcome.route) {
        WelcomeScreen(
            navigateToHome = {
                navController.navigate(route = RootScreen.Main.route)
            }
        )
    }
}