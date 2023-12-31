package com.practice.navigation_exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.widget.NestedScrollView
import androidx.navigation.NavHostController
import com.practice.navigation_exercise.core.navigation.MyInternalScreen

@Composable
fun MyScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "my")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate(MyInternalScreen.Following.route) {
                launchSingleTop = true
            }
        }) {
            Text("팔로잉")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate(MyInternalScreen.MyRecipe.route) {
                launchSingleTop = true
            }
        }) {
            Text("나의 레시피")
        }
        repeat(100) {
            Text("$it 나의 레시피")
        }

    }
}