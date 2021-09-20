package com.wainow.tp_lab_1.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wainow.tp_lab_1.domain.NumberInteractor
import com.wainow.tp_lab_1.ui.main.MainViewModel

class VMFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(NumberInteractor()) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
