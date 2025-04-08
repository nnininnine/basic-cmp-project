package org.example.basic_cmp_project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.example.basic_cmp_project.feature.home.presentation.HomeScreen
import org.example.basic_cmp_project.navigation.welcome.addWelcomeScreen

sealed class RootScreen(
    route: String
): Screen(route) {
    data object Welcome: RootScreen(
        route = "welcome"
    )

    data object  Main: RootScreen(
        route = "main"
    )
}

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = RootScreen.Welcome.route
    ) {
        addWelcomeScreen(navController)

        addMainGraph(popToWelcome = {
            navController.popBackStack(route = RootScreen.Welcome.route, inclusive = false, saveState = false)
        })
    }
}
