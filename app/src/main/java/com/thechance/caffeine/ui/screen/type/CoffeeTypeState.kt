package com.thechance.caffeine.ui.screen.type

import com.thechance.caffeine.model.CoffeeType

data class CoffeeTypeState(
    val coffeeTypes: List<CoffeeType> = emptyList(),
    val selectedCoffeeType: CoffeeType? = null
)
