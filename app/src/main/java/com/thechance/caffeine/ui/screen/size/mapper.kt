package com.thechance.caffeine.ui.screen.size

import com.thechance.caffeine.model.CoffeeSize

fun CoffeeSize.getML(): String {
    return when (this) {
        CoffeeSize.SMALL -> "150 ML"
        CoffeeSize.MEDIUM -> "200 ML"
        CoffeeSize.LARGE -> "400 ML"
    }
}

fun CoffeeSize.getLetter(): String {
    return when (this) {
        CoffeeSize.SMALL -> "S"
        CoffeeSize.MEDIUM -> "M"
        CoffeeSize.LARGE -> "L"
    }
}