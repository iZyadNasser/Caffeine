package com.thechance.caffeine.ui.screen.type

import androidx.lifecycle.ViewModel
import com.thechance.caffeine.DummyDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CoffeeTypeViewModel: ViewModel() {
    private val _state = MutableStateFlow(CoffeeTypeState())
    val state = _state.asStateFlow()

    init {
        loadCoffeeTypes()
    }

    private fun loadCoffeeTypes() {
        _state.update {
            it.copy(
                coffeeTypes = DummyDataSource.coffeeTypes
            )
        }
    }
}