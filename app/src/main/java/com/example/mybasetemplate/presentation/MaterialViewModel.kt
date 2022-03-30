package com.example.mybasetemplate.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *  매터리얼 전반에 사용하게 되는 ViewModel
 */
class MaterialViewModel : ViewModel() {

    val selectedSingleDate = MutableLiveData<Long>()

    val selectedRangedDate = MutableLiveData<Pair<Long, Long>>()
}
