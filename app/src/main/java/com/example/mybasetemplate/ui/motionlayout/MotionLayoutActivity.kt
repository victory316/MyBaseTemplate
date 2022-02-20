package com.example.mybasetemplate.ui.motionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybasetemplate.R
import com.example.mybasetemplate.databinding.ActivityMotionLayoutBinding
import com.example.mybasetemplate.presentation.MaterialViewModel
import com.example.mybasetemplate.presentation.MotionLayoutViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MotionLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMotionLayoutBinding

    @Inject
    lateinit var motionLayoutViewModel: MotionLayoutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_layout)

        setupUi()
    }

    private fun setupUi() {
        binding = ActivityMotionLayoutBinding.inflate(layoutInflater)

        with(binding) {
            viewModel = motionLayoutViewModel
        }

        setContentView(binding.root)
    }
}