package com.example.mybasetemplate.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybasetemplate.enums.IntroFeatures
import kotlinx.coroutines.launch

/**
 *  Intro page Viewmodel
 */
class IntroViewModel : ViewModel() {

    val onIntroEvent = MutableLiveData<IntroEvent>()

    fun openFunction(introFeatures: IntroEvent) {
        viewModelScope.launch {
            onIntroEvent.postValue(introFeatures)
        }
    }

    companion object {
        enum class IntroEvent {
            EVENT_OPEN_MATERIAL,
            EVENT_OPEN_WEATHER_API
        }
    }
}