package org.example.basic_cmp_project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import org.example.basic_cmp_project.feature.home.presentation.HomeScreen
import org.example.basic_cmp_project.navigation.RootNavGraph

@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        RootNavGraph(navController)
    }
}