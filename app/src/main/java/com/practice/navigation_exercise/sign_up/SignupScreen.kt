package com.practice.navigation_exercise.sign_up

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.practice.navigation_exercise.core.navigation.AuthScreen
import com.practice.navigation_exercise.core.navigation.MAIN_ROUTE

@Composable
fun SignUpScreen(navController: NavHostController, email: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "sign up",
            modifier = Modifier
                .clickable {
                    navController.navigate(MAIN_ROUTE) {
                        popUpTo(AuthScreen.SignIn.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
        )

        Text(text = "email : $email")
    }
}