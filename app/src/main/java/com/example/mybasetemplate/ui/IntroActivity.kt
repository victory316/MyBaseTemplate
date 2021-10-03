package com.example.mybasetemplate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybasetemplate.R

/**
 *  앱이 시작된 뒤로 사용 가능한 기능들을 나열하는 Activity
 */
class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        setupUi()
        subscribeUi()
    }

    private fun setupUi() {
        // TODO 신규로 구현한 기능들을 리스트 형으로 확인 가능하도록 구현.
    }

    private fun subscribeUi() {

    }
}