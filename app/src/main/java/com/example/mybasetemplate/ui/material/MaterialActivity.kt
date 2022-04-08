package com.example.mybasetemplate.ui.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.mybasetemplate.R
import com.example.mybasetemplate.databinding.ActivityMaterialBinding
import com.example.mybasetemplate.ext.replaceFragment
import com.example.mybasetemplate.presentation.MaterialViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 *  For testing various material components
 */
@AndroidEntryPoint
class MaterialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMaterialBinding

    @Inject
    lateinit var materialViewModel: MaterialViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUi()
        subscribeUi()
    }

    private fun setupUi() {
        binding = ActivityMaterialBinding.inflate(layoutInflater)

        replaceFragment(R.id.material_frame, MaterialBasicFragment.newInstance())

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_1 -> {
                    replaceFragment(R.id.material_frame, MaterialBasicFragment.newInstance())
                }
                R.id.page_2 -> {
                    replaceFragment(
                        R.id.material_frame,
                        MaterialBottomSheetFragment.newInstance(" ", "")
                    )
                }
                R.id.page_3 -> {
                    replaceFragment(R.id.material_frame, MaterialBasicFragment.newInstance())
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
