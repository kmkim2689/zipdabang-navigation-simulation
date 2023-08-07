package com.practice.navigation_exercise.component

import androidx.compose.foundation.clickable
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppBarDefault(
    text: String,
    onClick: () -> Unit
) {
    TopAppBar(title = {
        Text(
            text = text,
            modifier = Modifier
                .clickable {
                    onClick()
                }
        )
    })
}