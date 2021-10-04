package com.example.mybasetemplate.util

import android.widget.ImageView
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
            else -> {
                throw Exception("Wrong intro item")
            }
        }
    }
}