package com.practice.navigation_exercise

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.practice.navigation_exercise.core.navigation.HomeScreen

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "FirstScreen",
            modifier = Modifier
                .clickable {
                    navController.navigate(HomeScreen.Detail.route)
                }
        )
    }
}