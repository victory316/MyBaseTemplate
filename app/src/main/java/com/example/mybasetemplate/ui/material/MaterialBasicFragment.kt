package com.example.mybasetemplate.ui.material

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mybasetemplate.databinding.FragmentMaterialBasicBinding
import com.example.mybasetemplate.ext.showToast
import com.example.mybasetemplate.presentation.MaterialViewModel
import com.google.android.material.datepicker.MaterialDatePicker

/**
 *  기본적인 컴포넌트 사용 예를 보이는 Fragment
 */
class MaterialBasicFragment : Fragment() {
    lateinit var binding: FragmentMaterialBasicBinding
    lateinit var materialViewModel: MaterialViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO DI로 주입
        materialViewModel = MaterialViewModel().apply {
            selectedSingleDate.postValue(System.currentTimeMillis())
            selectedRangedDate.postValue(
                Pair(
                    System.currentTimeMillis(),
                    System.currentTimeMillis()
                )
            )
        }
    }

    private fun setupUi() {
        with(binding) {
            viewModel = materialViewModel
            lifecycleOwner = viewLifecycleOwner

            datePickerButton.setOnClickListener {
                MaterialDatePicker.Builder.datePicker()
                    .setSelection(MaterialDatePicker.thisMonthInUtcMilliseconds())
                    .build()
                    .apply {
                        addOnPositiveButtonClickListener {
                            materialViewModel.selectedSingleDate.postValue(it)
                            showToast("날짜가 선택되었어요.")
                        }
                    }.show(parentFragmentManager, null)
            }

            datePickerRangeButton.setOnClickListener {
                MaterialDatePicker.Builder.dateRangePicker()
                    .build()
                    .apply {
                        addOnPositiveButtonClickListener {

                            materialViewModel.selectedRangedDate.postValue(
                                Pair(it.first, it.second)
                            )

                            showToast("날짜가 선택되었어요.")
                        }
                    }.show(parentFragmentManager, null)
            }
        }
    }

    private fun subscribeUi() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentMaterialBasicBinding.inflate(inflater, container, false)

        setupUi()
        subscribeUi()

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = MaterialBasicFragment()
    }
}