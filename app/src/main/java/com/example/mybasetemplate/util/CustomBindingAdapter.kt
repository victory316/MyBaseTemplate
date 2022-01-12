package com.example.mybasetemplate.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.mybasetemplate.R
import com.example.mybasetemplate.enums.IntroFeatures
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DateFormat

object CustomBindingAdapter {

    @JvmStatic
    @BindingAdapter("introItemIcon")
    fun setIntroItemIcon(view: ImageView, feature: IntroFeatures) {

        when (feature) {
            IntroFeatures.FEATURE_MATERIAL -> {
                view.setImageResource(R.drawable.icon_material)
            }
            IntroFeatures.FEATURE_WEATHER_API -> {
                view.setImageResource(R.drawable.outline_wb_sunny_black_48)
            }
            IntroFeatures.FEATURE_COMPOSE -> {
                view.setImageResource(R.drawable.outline_wb_sunny_black_48)
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
            IntroFeatures.FEATURE_COMPOSE -> {
                view.text = view.context.getText(R.string.item_compose)
            }
        }
    }

    // ref: https://stackoverflow.com/questions/454315/how-to-format-date-and-time-in-android
    @JvmStatic
    @BindingAdapter("applyDateWithLong")
    fun setDateWithLong(view: TextView, timeInMillis: Long) {
        DateFormat.getDateInstance().format(timeInMillis).let {
            view.text = it
        }
    }

//    @JvmStatic
//    @BindingAdapter("onItemClick")
//    fun setOnItemClick(view: View, function: () -> Unit) {
//        val scope = CoroutineScope(Dispatchers.IO).launch {
//
//        }
//    }
}