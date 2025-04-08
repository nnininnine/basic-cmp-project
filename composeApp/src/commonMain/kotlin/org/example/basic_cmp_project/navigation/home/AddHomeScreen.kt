package org.example.basic_cmp_project.navigation.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.example.basic_cmp_project.feature.home.presentation.HomeScreen
import org.example.basic_cmp_project.navigation.MainScreen

fun NavGraphBuilder.addHomeScreen() {
    composable(route = MainScreen.Home.route) {
        HomeScreen()
    }
}