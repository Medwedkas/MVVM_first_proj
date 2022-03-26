package com.example.prak_2_6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomNumberViewModel : ViewModel() {
    val currentRandomNumber: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

    fun generate(): String {
        currentRandomNumber.value = (0..50).shuffled().last()
        return currentRandomNumber.toString()
    }

    companion object {
        private var INSTANCE: RandomNumberViewModel? = null

        fun getInstance(): RandomNumberViewModel {
            return INSTANCE ?: synchronized(this)
            {
                val instance = RandomNumberViewModel()
                INSTANCE = instance
                instance

            }
        }
    }
}
