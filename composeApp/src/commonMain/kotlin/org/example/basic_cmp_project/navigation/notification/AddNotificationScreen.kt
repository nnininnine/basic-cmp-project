package org.example.basic_cmp_project.navigation.notification

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.example.basic_cmp_project.feature.notification.presentation.NotificationScreen
import org.example.basic_cmp_project.navigation.MainScreen

fun NavGraphBuilder.addNotificationScreen() {
    composable(route = MainScreen.Notification.route) {
        NotificationScreen()
    }
}