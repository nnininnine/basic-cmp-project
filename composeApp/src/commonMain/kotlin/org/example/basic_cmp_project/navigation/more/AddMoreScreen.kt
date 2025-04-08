package org.example.basic_cmp_project.navigation.more

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.example.basic_cmp_project.feature.more.presentation.MoreScreen
import org.example.basic_cmp_project.navigation.MainScreen

fun NavGraphBuilder.addMoreScreen() {
    composable(route = MainScreen.More.route) {
        MoreScreen()
    }
}