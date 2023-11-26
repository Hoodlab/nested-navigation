package hoods.com.nestednavigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import hoods.com.nestednavigation.screens.auth.ForgotPasswordScreen
import hoods.com.nestednavigation.screens.auth.LoginScreen
import hoods.com.nestednavigation.screens.auth.SignUp
import hoods.com.nestednavigation.screens.home.HomeScreen
import hoods.com.nestednavigation.screens.home.ScreenOne
import hoods.com.nestednavigation.screens.home.ScreenTwo

enum class Destinations {
    SIGNUP, LOGIN, FORGOT_PASSWORD, HOME_SCREEN, SCREEN_ONE, SCREEN_TWO
}

@Composable
fun Navigation(navController: NavHostController, isLoggedIn: Boolean) {
    NavHost(navController = navController, startDestination = Destinations.LOGIN.name) {
        composable(Destinations.LOGIN.name) {
            LoginScreen(
                onLogin = { navController.navigate(Destinations.HOME_SCREEN.name) },
                onSignUp = { navController.navigate(Destinations.SIGNUP.name) },
                onForgotPassword = { navController.navigate(Destinations.FORGOT_PASSWORD.name) }
            )
        }

        composable(Destinations.FORGOT_PASSWORD.name) {
            ForgotPasswordScreen {
                navController.navigate(Destinations.HOME_SCREEN.name)
            }
        }

        composable(Destinations.SIGNUP.name) {
            SignUp {
                navController.navigate(Destinations.HOME_SCREEN.name)
            }
        }

        composable(Destinations.HOME_SCREEN.name) {
            HomeScreen(
                onNavigateToScreenOne = {
                    navController.navigate(Destinations.SCREEN_ONE.name)
                },
                onNavigateToScreenTwo = {
                    navController.navigate(Destinations.SCREEN_TWO.name)
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

    LaunchedEffect(Unit) {
        if (!isLoggedIn) {
            navController.navigate(Destinations.LOGIN.name)
        }
    }
}