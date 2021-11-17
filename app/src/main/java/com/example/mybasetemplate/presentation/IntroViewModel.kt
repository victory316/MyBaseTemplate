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

    fun openFunction(introFeatures: IntroFeatures) {
        viewModelScope.launch {
            when (introFeatures) {
                IntroFeatures.FEATURE_MATERIAL -> {
                    onIntroEvent.postValue(IntroEvent.EVENT_OPEN_MATERIAL)
                }
                IntroFeatures.FEATURE_WEATHER_API -> {
                    onIntroEvent.postValue(IntroEvent.EVENT_OPEN_WEATHER_API)
                }
            }
        }
    }

    companion object {
        enum class IntroEvent {
            EVENT_OPEN_MATERIAL,
            EVENT_OPEN_WEATHER_API
        }
    }
}