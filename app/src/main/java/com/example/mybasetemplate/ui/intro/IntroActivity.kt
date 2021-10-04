package com.example.mybasetemplate.ui.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybasetemplate.R
import com.example.mybasetemplate.databinding.ActivityIntroBinding

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


        // TODO 신규로 구현한 기능들을 리스트 형으로 확인 가능하도록 구현.
    }

    private fun subscribeUi() {

    }
}