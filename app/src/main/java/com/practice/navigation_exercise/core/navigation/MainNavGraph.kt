package com.practice.navigation_exercise.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.practice.navigation_exercise.BasketScreen
import com.practice.navigation_exercise.FollowingScreen
import com.practice.navigation_exercise.HomeScreen
import com.practice.navigation_exercise.MarketScreen
import com.practice.navigation_exercise.MyRecipeScreen
import com.practice.navigation_exercise.MyScreen
import com.practice.navigation_exercise.RecipeScreen

@Composable
fun MainNavGraph(outerNavController: NavHostController, innerNavController: NavHostController) {
    NavHost(
        startDestination = BottomBarScreen.Home.route,
        navController = innerNavController
    ) {
        composable(
            route = BottomBarScreen.Home.route
        ) {
            HomeScreen(outerNavController)
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
            MyScreen(innerNavController)
        }
        composable(
            route = BottomBarScreen.Recipe.route
        ) {
            RecipeScreen()
        }

        composable(
            route = MyInternalScreen.Following.route
        ) {
            FollowingScreen()
        }

        composable(
            route = MyInternalScreen.MyRecipe.route
        ) {
            MyRecipeScreen()
        }
    }
}