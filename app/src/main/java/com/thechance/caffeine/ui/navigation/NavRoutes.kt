package com.thechance.caffeine.ui.navigation

import com.thechance.caffeine.model.CoffeeType
import kotlinx.serialization.Serializable

@Serializable
object IntroRoute

@Serializable
object CoffeeTypeRoute

@Serializable
data class CoffeeSizeRoute(
    val coffeeType: CoffeeType
)