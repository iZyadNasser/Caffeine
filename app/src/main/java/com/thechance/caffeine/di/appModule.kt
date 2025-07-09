package com.thechance.caffeine.di

import com.thechance.caffeine.ui.screen.size.CoffeeSizeViewModel
import com.thechance.caffeine.ui.screen.type.CoffeeTypeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::CoffeeTypeViewModel)
    viewModelOf(::CoffeeSizeViewModel)
}