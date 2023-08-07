package com.practice.navigation_exercise.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

const val ROOT_ROUTE = "root"
const val MAIN_ROUTE = "main"
const val AUTH_ROUTE = "auth"
const val SPLASH_ROUTE = "splash"
const val SEARCH_ROUTE = "search"

// LoginScreen or AuthScreen
sealed class AuthScreen(val route: String) {
    object SignIn: AuthScreen(route = "auth/sign_in")
    object SignUp: AuthScreen(route = "auth/sign_up/{email}")

}

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: BottomBarScreen(
        route = "home",
        title = "home",
        icon = Icons.Default.Home
    )
    object Market: BottomBarScreen(
        route = "market",
        title = "market",
        icon = Icons.Default.Place
    )
    object Basket: BottomBarScreen(
        route = "basket",
        title = "basket",
        icon = Icons.Default.ShoppingCart
    )
    object My: BottomBarScreen(
        route = "my",
        title = "my",
        icon = Icons.Default.Settings
    )
    object Recipe: BottomBarScreen(
        route = "recipe",
        title = "recipe",
        icon = Icons.Default.Share
    )
}

sealed class GoodsScreen(val route: String) {
    class Category(val category: String)
        : GoodsScreen(route = "goods?category={category}")
}

sealed class HomeScreen(val route: String) {
    object Guide: HomeScreen(route = "home/guide")

}

sealed class RecipeScreen(val route: String) {
    class Category(category: String)
        :RecipeScreen(route = "recipe?category={category}")
}

sealed class SharedScreen(val route: String) {
    object Search: SharedScreen(route = "search?query={query}") {
        fun passQuery(query: String): String {
            return "search?query=$query"
        }
    }
    data class GoodsDetail(val goodsId: Long)
        : SharedScreen(route = "goods?id={goodsId}")
    data class RecipeDetail(val recipeId: Long)
        : SharedScreen(route = "recipe?id={recipeId}")
}

sealed class MyInternalScreen(val route: String) {
    object Following: MyInternalScreen(route = "my/following")
    object MyRecipe: MyInternalScreen("my/recipe")
}