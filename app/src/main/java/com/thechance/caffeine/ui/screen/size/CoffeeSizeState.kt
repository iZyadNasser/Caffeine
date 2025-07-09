package com.thechance.caffeine.ui.screen.size

import com.thechance.caffeine.model.CoffeeAmount
import com.thechance.caffeine.model.CoffeeSize
import com.thechance.caffeine.model.CoffeeType

data class CoffeeSizeState(
    val coffeeSizes: List<CoffeeSize> = listOf(
        CoffeeSize.SMALL,
        CoffeeSize.MEDIUM,
        CoffeeSize.LARGE
    ),
    val selectedCoffeeSize: CoffeeSize = CoffeeSize.MEDIUM,
    val coffeeAmounts: List<CoffeeAmount> = listOf(
        CoffeeAmount.LOW,
        CoffeeAmount.MEDIUM,
        CoffeeAmount.HIGH
    ),
    val selectedCoffeeAmount: CoffeeAmount = CoffeeAmount.LOW
)
