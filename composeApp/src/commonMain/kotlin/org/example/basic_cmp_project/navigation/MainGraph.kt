package org.example.basic_cmp_project.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.basic_cmp_project.navigation.home.addHomeScreen
import org.example.basic_cmp_project.navigation.more.addMoreScreen
import org.example.basic_cmp_project.navigation.notification.addExampleScreen
import org.example.basic_cmp_project.navigation.profile.addProfileScreen

sealed class MainScreen(
    route: String, val title: String, val icon: ImageVector
) : Screen(route) {
    data object Home : MainScreen(
        route = "home", title = "Home", icon = Icons.Default.Home
    )

    data object Profile : MainScreen(
        route = "profile", title = "Profile", icon = Icons.Default.Person
    )

    data object Example : MainScreen(
        route = "Example", title = "Example", icon = Icons.Default.Info
    )

    data object More : MainScreen(
        route = "more", title = "More", icon = Icons.Default.Menu
    )

    companion object {
        fun getBottomNavigationItems(): List<MainScreen> {
            return listOf(
                Home, Profile, Example, More
            )
        }
    }
}

@Composable
fun MainScreen(popToWelcome: () -> Unit) {
    val navigationItems = MainScreen.getBottomNavigationItems()
    val mainNavController = rememberNavController()
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(navigationItems[selectedNavigationIndex.intValue].title)
        })
    }, bottomBar = {
        NavigationBar(containerColor = Color.White) {
            navigationItems.forEachIndexed { index, screen ->
                NavigationBarItem(selected = selectedNavigationIndex.intValue == index, onClick = {
                    selectedNavigationIndex.intValue = index
                    mainNavController.navigate(screen.route)
                }, icon = {
                    Icon(imageVector = screen.icon, contentDescription = screen.title)
                }, label = {
                    Text(screen.title, fontSize = 12.sp)
                })
            }
        }
    }) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = mainNavController,
            startDestination = MainScreen.Home.route
        ) {
            addHomeScreen()
            addProfileScreen()
            addExampleScreen()
            addMoreScreen()
        }
    }
}

fun NavGraphBuilder.addMainGraph(popToWelcome: () -> Unit) {
    composable(route = RootScreen.Main.route) {
        MainScreen(popToWelcome)
    }
}