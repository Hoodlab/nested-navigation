package hoods.com.nestednavigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import hoods.com.nestednavigation.screens.auth.ForgotPasswordScreen
import hoods.com.nestednavigation.screens.auth.LoginScreen
import hoods.com.nestednavigation.screens.auth.SignUp
import hoods.com.nestednavigation.screens.home.HomeScreen
import hoods.com.nestednavigation.screens.home.ScreenOne
import hoods.com.nestednavigation.screens.home.ScreenTwo

@Composable
fun NestedNavigation(navController: NavHostController, isLoggedIn: Boolean) {
    NavHost(navController, startDestination = "home_graph") {
        auth(navController)
        home(navController) 
    }
    LaunchedEffect(Unit) {
        if (!isLoggedIn) {
            navController.navigateToSingleTop("auth_graph")
        }
    }

}


fun NavGraphBuilder.auth(navController: NavController) {
    navigation(startDestination = Destinations.LOGIN.name, route = "auth_graph") {
        composable(Destinations.LOGIN.name) {
            LoginScreen(
                onLogin = { navController.navigateToSingleTop("home_graph") },
                onSignUp = { navController.navigateToSingleTop(Destinations.SIGNUP.name) },
                onForgotPassword = { navController.navigateToSingleTop(Destinations.FORGOT_PASSWORD.name) }
            )
        }

        composable(Destinations.FORGOT_PASSWORD.name) {
            ForgotPasswordScreen {
                navController.navigateToSingleTop("home_graph")
            }
        }

        composable(Destinations.SIGNUP.name) {
            SignUp {
                navController.navigateToSingleTop("home_graph")
            }
        }
    }
}

fun NavGraphBuilder.home(navController: NavController) {
    navigation(startDestination = Destinations.HOME_SCREEN.name, route = "home_graph") {
        composable(Destinations.HOME_SCREEN.name) {
            HomeScreen(
                onNavigateToScreenOne = {
                    navController.navigateToSingleTop(Destinations.SCREEN_ONE.name)
                },
                onNavigateToScreenTwo = {
                    navController.navigateToSingleTop(Destinations.SCREEN_TWO.name)
                }
            )
        }
        composable(Destinations.SCREEN_ONE.name) {
            ScreenOne {
                navController.navigateUp()
            }
        }
        composable(Destinations.SCREEN_TWO.name) {
            ScreenTwo {
                navController.navigateUp()
            }
        }
    }
}

fun NavController.navigateToSingleTop(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}







