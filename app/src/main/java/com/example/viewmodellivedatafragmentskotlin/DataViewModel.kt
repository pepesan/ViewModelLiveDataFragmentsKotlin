package com.example.viewmodellivedatafragmentskotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel: ViewModel() {
    var count: Int = 0
    val dato: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    init {
        dato.value= "Algo"
    }
}