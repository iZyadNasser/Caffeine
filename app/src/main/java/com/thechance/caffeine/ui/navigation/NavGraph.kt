package com.thechance.caffeine.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.thechance.caffeine.ui.screen.intro.IntroScreen
import com.thechance.caffeine.ui.screen.type.CoffeeTypeRoot

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
) {

    NavHost(
        navController = navController,
        startDestination = IntroRoute
    ) {

        composable<IntroRoute> {
            IntroScreen(
                navigateToCoffeeType = {
                    navController.navigate(CoffeeTypeRoute)
                }
            )
        }

        composable<CoffeeTypeRoute> {
            CoffeeTypeRoot(
                navigateToCoffeeSize = {
                    navController.navigate(CoffeeSizeRoute(it))
                }
            )
        }

        composable<CoffeeSizeRoute> {
            val args = it.toRoute<CoffeeSizeRoute>()
            // TODO
        }

    }
}