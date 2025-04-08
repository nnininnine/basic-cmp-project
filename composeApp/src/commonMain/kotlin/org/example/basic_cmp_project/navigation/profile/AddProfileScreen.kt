package org.example.basic_cmp_project.navigation.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.example.basic_cmp_project.feature.profile.presentation.ProfileScreen
import org.example.basic_cmp_project.navigation.MainScreen

fun NavGraphBuilder.addProfileScreen() {
    composable(route = MainScreen.Profile.route) {
        ProfileScreen()
    }
}