package com.example.mybasetemplate.ui.material

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mybasetemplate.R
import com.example.mybasetemplate.databinding.FragmentMaterialBasicBinding
import com.example.mybasetemplate.ext.showToast
import com.example.mybasetemplate.presentation.MaterialViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

/**
 *  기본적인 컴포넌트 사용 예를 보이는 Fragment
 */
@AndroidEntryPoint
class MaterialBasicFragment : Fragment() {
    lateinit var binding: FragmentMaterialBasicBinding
    private val materialViewModel: MaterialViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        materialViewModel.apply {
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

            floatingActionButton.shrink()

            svBase.setOnScrollChangeListener { _, _, scrollY, _, _ ->

                if (scrollY > 50L) {
                    floatingActionButton.extend()
                } else {
                    floatingActionButton.shrink()
                }
            }

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

            floatingActionButton.setOnClickListener {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle(resources.getString(R.string.title_show_dialog))
                    .setMessage(resources.getString(R.string.content_sample_dialog))
                    .setNegativeButton(resources.getString(R.string.content_ok_button_dialog)) { _, _ ->

                    }
                    .setPositiveButton(resources.getString(R.string.content_show_big_dialog)) { _, _ ->
                        // Respond to positive button press
                    }
                    .show()
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