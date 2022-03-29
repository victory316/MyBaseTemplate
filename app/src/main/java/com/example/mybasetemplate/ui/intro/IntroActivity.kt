package com.example.mybasetemplate.ui.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mybasetemplate.base.BaseActivity
import com.example.mybasetemplate.data.IntroFeatureData
import com.example.mybasetemplate.databinding.ActivityIntroBinding
import com.example.mybasetemplate.enums.IntroFeatures
import com.example.mybasetemplate.ext.startActivity
import com.example.mybasetemplate.presentation.IntroViewModel
import com.example.mybasetemplate.ui.compose.ComposeActivity
import com.example.mybasetemplate.ui.material.MaterialActivity
import com.example.mybasetemplate.ui.motionlayout.MotionLayoutActivity
import com.example.mybasetemplate.ui.weather.WeatherActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 *  앱이 시작된 뒤로 사용 가능한 기능들을 나열하는 Activity
 */
@AndroidEntryPoint
class IntroActivity : BaseActivity() {

    private lateinit var binding: ActivityIntroBinding
    private lateinit var adapter: IntroAdapter
    private val introViewModel: IntroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        subscribeUi()
    }

    private fun setupUi() {
        binding = ActivityIntroBinding.inflate(layoutInflater)
        adapter = IntroAdapter(introViewModel)
        setContentView(binding.root)

        with(binding) {
            lifecycleOwner = this@IntroActivity
            middleRecyclerView.adapter = adapter
            viewModel = introViewModel
        }

        binding.middleRecyclerView.setItemViewCacheSize(10)

        adapter.setItems(
            listOf(
                IntroFeatureData(1, IntroFeatures.FEATURE_MATERIAL),
                IntroFeatureData(1, IntroFeatures.FEATURE_WEATHER_API),
                IntroFeatureData(1, IntroFeatures.FEATURE_COMPOSE),
                IntroFeatureData(1, IntroFeatures.FEATURE_MOTION_LAYOUT),
            )
        )

        // TODO Featured Items
        /**
         *  1. Weather API Search
         *  2. Motion Layout
         *  3. Material Components
         */
    }

    private fun subscribeUi() {
        with(introViewModel) {
            onIntroEvent.observe(this@IntroActivity, {
                when (it) {
                    IntroViewModel.Companion.IntroEvent.EVENT_OPEN_MATERIAL -> {
                        startActivity(MaterialActivity())
                    }
                    IntroViewModel.Companion.IntroEvent.EVENT_OPEN_WEATHER_API -> {
                        startActivity(WeatherActivity())
                    }
                    IntroViewModel.Companion.IntroEvent.EVENT_OPEN_COMPOSE -> {
                        startActivity(ComposeActivity())
                    }
                    IntroViewModel.Companion.IntroEvent.EVENT_OPEN_MOTION_LAYOUT -> {
                        startActivity(MotionLayoutActivity())
                    }

                    else -> {
                        throw Exception("Wrong event called")
                    }
                }
            })
        }
    }
}