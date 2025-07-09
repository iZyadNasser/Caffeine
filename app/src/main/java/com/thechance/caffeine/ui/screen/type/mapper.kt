package com.thechance.caffeine.ui.screen.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.thechance.caffeine.R
import com.thechance.caffeine.model.CoffeeType

@DrawableRes
fun CoffeeType.getImageResource(): Int {
    return when (this) {
        CoffeeType.BLACK -> R.drawable.im_coffe_black
        CoffeeType.LATTE -> R.drawable.im_coffe_latte
        CoffeeType.MACCHIATO -> R.drawable.im_coffe_macchiato
        CoffeeType.ESPRESSO -> R.drawable.im_coffe_espresso
    }
}

@StringRes
fun CoffeeType.getTitleResource(): Int {
    return when (this) {
        CoffeeType.BLACK -> R.string.black
        CoffeeType.LATTE -> R.string.latte
        CoffeeType.MACCHIATO -> R.string.macchiato
        CoffeeType.ESPRESSO -> R.string.espresso
    }
}