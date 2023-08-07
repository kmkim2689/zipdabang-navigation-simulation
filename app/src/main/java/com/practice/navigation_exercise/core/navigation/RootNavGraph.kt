package com.practice.navigation_exercise.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.practice.navigation_exercise.MainScreen
import com.practice.navigation_exercise.SearchScreen
import com.practice.navigation_exercise.SplashScreen

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SPLASH_ROUTE,
        route = ROOT_ROUTE
    ) {
        composable(route = SPLASH_ROUTE) {
            SplashScreen(navController = navController)
        }
        authNavGraph(navController = navController)
//        mainNavGraph(navController = navController)
        composable(route = MAIN_ROUTE) {
            MainScreen(navController = navController)
        }
        // search
        composable(
            route = SharedScreen.Search.route,
            arguments = listOf(
                // appbar에서의 클릭 이벤트로 쿼리문자열 전달받은 결과를 처리하는 부분
                navArgument(name = "query") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) { backStackEntry ->
            SearchScreen(navController = navController, query = backStackEntry.arguments?.getString("query"))
        }
    }
}