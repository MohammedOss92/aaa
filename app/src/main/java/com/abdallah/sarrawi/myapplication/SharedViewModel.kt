package com.abdallah.sarrawi.myapplication

import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private var selectedFontPosition = 0

    fun getSelectedFontPosition(): Int {
        return selectedFontPosition
    }

    fun setSelectedFontPosition(position: Int) {
        selectedFontPosition = position
    }
}
