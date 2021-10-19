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

        supportFragmentManager.beginTransaction()
            .replace(R.id.material_frame, MaterialBasicFragment.newInstance("", ""))
            .commit()

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.material_frame, MaterialBasicFragment.newInstance("", ""))
                        .commit()
                }
                R.id.page_2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.material_frame,
                            MaterialBottomSheetFragment.newInstance("", "")
                        ).commit()
                }
                R.id.page_3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.material_frame, MaterialBasicFragment.newInstance("", ""))
                        .commit()
                }

                else -> {

                }
            }

            return@setOnItemSelectedListener true
        }

        setContentView(binding.root)
    }

    private fun subscribeUi() {

    }

}