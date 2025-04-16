package org.example.basic_cmp_project.navigation.notification

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.example.basic_cmp_project.feature.example.presentation.ExampleScreen
import org.example.basic_cmp_project.navigation.MainScreen

fun NavGraphBuilder.addExampleScreen() {
    composable(route = MainScreen.Example.route) {
        ExampleScreen()
    }
}