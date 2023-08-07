package com.practice.navigation_exercise.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.practice.navigation_exercise.BasketScreen
import com.practice.navigation_exercise.HomeScreen
import com.practice.navigation_exercise.MarketScreen
import com.practice.navigation_exercise.MyScreen
import com.practice.navigation_exercise.RecipeScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        startDestination = BottomBarScreen.Home.route,
        navController = navController
    ) {
        composable(
            route = BottomBarScreen.Home.route
        ) {
            HomeScreen()
        }
        composable(
            route = BottomBarScreen.Basket.route
        ) {
            BasketScreen()
        }
        composable(
            route = BottomBarScreen.Market.route
        ) {
            MarketScreen()
        }
        composable(
            route = BottomBarScreen.My.route
        ) {
            MyScreen()
        }
        composable(
            route = BottomBarScreen.Recipe.route
        ) {
            RecipeScreen()
        }

    }

}