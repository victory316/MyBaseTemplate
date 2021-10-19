package com.example.mybasetemplate.ui.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybasetemplate.R
import com.example.mybasetemplate.databinding.ActivityMaterialBinding

class MaterialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMaterialBinding
    private lateinit var pagerAdapter: MaterialPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUi()
        subscribeUi()
    }

    private fun setupUi() {
        binding = ActivityMaterialBinding.inflate(layoutInflater)
        pagerAdapter = MaterialPagerAdapter(supportFragmentManager, lifecycle)

        with(binding) {
            mainViewPager.adapter = pagerAdapter
        }

        pagerAdapter.setFragments(MaterialBasicFragment.newInstance("", ""))

        setContentView(binding.root)
    }

    private fun subscribeUi() {

    }

}