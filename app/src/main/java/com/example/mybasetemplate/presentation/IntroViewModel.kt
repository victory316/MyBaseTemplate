package com.example.mybasetemplate.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybasetemplate.data.IntroRepository
import com.example.mybasetemplate.enums.IntroFeatures
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *  Intro page Viewmodel
 */
class IntroViewModel() : ViewModel() {

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
                IntroFeatures.FEATURE_COMPOSE -> {
                    onIntroEvent.postValue(IntroEvent.EVENT_OPEN_COMPOSE)
                }
                IntroFeatures.FEATURE_MOTION_LAYOUT -> {
                    onIntroEvent.postValue(IntroEvent.EVENT_OPEN_MOTION_LAYOUT)
                }
            }
        }
    }

    companion object {
        enum class IntroEvent {
            EVENT_OPEN_MATERIAL,
            EVENT_OPEN_WEATHER_API,
            EVENT_OPEN_COMPOSE,
            EVENT_OPEN_MOTION_LAYOUT
        }
    }
}
