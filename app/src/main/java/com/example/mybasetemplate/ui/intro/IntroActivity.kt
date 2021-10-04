package com.example.mybasetemplate.ui.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybasetemplate.R
import com.example.mybasetemplate.data.IntroFeatureData
import com.example.mybasetemplate.databinding.ActivityIntroBinding
import com.example.mybasetemplate.enums.IntroFeatures

/**
 *  앱이 시작된 뒤로 사용 가능한 기능들을 나열하는 Activity
 */
class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    private lateinit var adapter: IntroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        subscribeUi()
    }

    private fun setupUi() {
        binding = ActivityIntroBinding.inflate(layoutInflater)
        adapter = IntroAdapter(this@IntroActivity)
        setContentView(binding.root)

        with(binding) {
            middleRecyclerView.adapter = adapter
        }

        adapter.setItems(
            listOf(
                IntroFeatureData(1, IntroFeatures.FEATURE_MATERIAL),
                IntroFeatureData(1, IntroFeatures.FEATURE_WEATHER_API)
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

    }
}