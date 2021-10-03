package com.example.mybasetemplate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybasetemplate.R
import com.example.mybasetemplate.ext.setDelayedFunction
import com.example.mybasetemplate.ext.startActivity
import com.example.mybasetemplate.ext.startActivityClearTop

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