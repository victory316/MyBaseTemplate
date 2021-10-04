package com.example.mybasetemplate.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.mybasetemplate.R
import com.example.mybasetemplate.enums.IntroFeatures

object CustomBindingAdapter {

    @JvmStatic
    @BindingAdapter("introItemIcon")
    fun setIntroItemIcon(view: ImageView, feature: IntroFeatures) {

        when (feature) {
            IntroFeatures.FEATURE_MATERIAL -> {
                view.setImageResource(R.drawable.icon_material)
            }
            IntroFeatures.FEATURE_WEATHER_API -> {

            }
        }
    }

    @JvmStatic
    @BindingAdapter("introItemTitle")
    fun setIntroItemTitleText(view: TextView, feature: IntroFeatures) {
        when (feature) {
            IntroFeatures.FEATURE_MATERIAL -> {
                view.text = view.context.getText(R.string.item_material)
            }
            IntroFeatures.FEATURE_WEATHER_API -> {
                view.text = view.context.getText(R.string.item_weather_api)
            }
        }
    }
}