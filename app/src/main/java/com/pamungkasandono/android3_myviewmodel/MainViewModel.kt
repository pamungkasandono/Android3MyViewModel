package com.pamungkasandono.android3_myviewmodel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var result = 0

    fun calc(width: String, height: String, length: String) {
        result = width.toInt() * height.toInt() * length.toInt()
    }
}