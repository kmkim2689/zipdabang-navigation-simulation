package com.practice.navigation_exercise.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.practice.navigation_exercise.BasketScreen
import com.practice.navigation_exercise.FollowingScreen
import com.practice.navigation_exercise.HomeScreen
import com.practice.navigation_exercise.MarketScreen
import com.practice.navigation_exercise.MyRecipeScreen
import com.practice.navigation_exercise.MyScreen
import com.practice.navigation_exercise.RecipeScreen

@Composable
fun MyNavGraph(navController: NavHostController) {
    NavHost(
        startDestination = BottomBarScreen.My.route,
        navController = navController
    ) {
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