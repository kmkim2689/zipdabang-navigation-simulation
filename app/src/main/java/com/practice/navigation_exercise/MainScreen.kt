package com.practice.navigation_exercise

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.practice.navigation_exercise.component.AppBarDefault
import com.practice.navigation_exercise.core.navigation.BottomBarScreen
import com.practice.navigation_exercise.core.navigation.MainNavGraph
import com.practice.navigation_exercise.core.navigation.SEARCH_ROUTE
import com.practice.navigation_exercise.core.navigation.SharedScreen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {

    // inner nav controller needed
    // https://stackoverflow.com/questions/69738397/jetpackcompose-navigation-nested-graphs-cause-viewmodelstore-should-be-set-befo
    val navControllerForMainScreen = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController = navControllerForMainScreen)
        },
        topBar = {
            AppBarDefault(
                text = "집다방",
                onClick = {
                    navController.navigate(SharedScreen.Search.passQuery("커피"))
                }
            )
        }
    ) {
        MainNavGraph(navController = navControllerForMainScreen)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf<BottomBarScreen>(
        BottomBarScreen.Market,
        BottomBarScreen.Basket,
        BottomBarScreen.Home,
        BottomBarScreen.Recipe,
        BottomBarScreen.My
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        onClick = {
            navController.navigate(screen.route) {
                // backstack 동작을 설정 -> 뒤로가기 버튼 누를 시, 그냥 나가도록 설정하고 singleTop launchmode로 설정
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        icon = { 
            Icon(
                imageVector = screen.icon,
                contentDescription = "Nav Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true
    )
}