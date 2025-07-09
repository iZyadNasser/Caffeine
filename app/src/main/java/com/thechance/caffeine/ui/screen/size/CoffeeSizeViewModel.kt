package com.thechance.caffeine.ui.screen.size

import androidx.lifecycle.ViewModel
import com.thechance.caffeine.model.CoffeeSize
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CoffeeSizeViewModel: ViewModel(), CoffeeSizeInteractionHandler {
    private val _state = MutableStateFlow(CoffeeSizeState())
    val state = _state.asStateFlow()

    override fun onCoffeeSizeClick(coffeeSize: CoffeeSize) {
        _state.update {
            it.copy(selectedCoffeeSize = coffeeSize)
        }
    }


}