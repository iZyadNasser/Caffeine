package com.thechance.caffeine.ui.screen.size

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CoffeeSizeViewModel: ViewModel() {
    private val _state = MutableStateFlow(CoffeeSizeState())
    val state = _state.asStateFlow()


}