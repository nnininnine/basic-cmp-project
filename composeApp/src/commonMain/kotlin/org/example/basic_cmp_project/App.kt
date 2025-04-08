package org.example.basic_cmp_project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import org.example.basic_cmp_project.navigation.RootNavGraph
import org.koin.compose.KoinContext

@Composable
fun App() {
    KoinContext {
        MaterialTheme {
            val navController = rememberNavController()
            RootNavGraph(navController)
        }
    }
}