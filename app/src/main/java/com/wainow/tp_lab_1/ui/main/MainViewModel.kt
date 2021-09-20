package com.wainow.tp_lab_1.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wainow.tp_lab_1.domain.Number
import com.wainow.tp_lab_1.domain.NumberInteractor

class MainViewModel(val interactor: NumberInteractor) : ViewModel() {
    private val numbers: MutableLiveData<Collection<Int>> = MutableLiveData()

    fun setMostFrequent(n: Collection<Int>){
        with(interactor){
            numbers.value = mostFrequent(numFrequency(n))
        }
    }

    fun getMostFrequent() = numbers.value
}