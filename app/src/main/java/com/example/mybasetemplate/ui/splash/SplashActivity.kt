package com.example.mybasetemplate.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mybasetemplate.R
import com.example.mybasetemplate.ext.setDelayedFunction
import com.example.mybasetemplate.ext.startActivityClearTop
import com.example.mybasetemplate.ui.intro.IntroActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setupUi()
    }

    private fun setupUi() {
        setDelayedFunction(
            function = {
                startActivityClearTop(IntroActivity())
                finish()
            },
            delay = SPLASH_DELAY
        )
    }

    companion object {
        const val SPLASH_DELAY = 1500L
    }
}