package com.practice.navigation_exercise.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.practice.navigation_exercise.sign_up.SignInScreen
import com.practice.navigation_exercise.sign_up.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        startDestination = AuthScreen.SignIn.route,
        route = AUTH_ROUTE
    ) {
        composable(
            route = AuthScreen.SignIn.route
        ) {
            SignInScreen(navController)
        }
        composable(
            route = AuthScreen.SignUp.route
        ) { backStackEntry ->
            SignUpScreen(navController, backStackEntry.arguments?.getString("email"))
        }
    }

}