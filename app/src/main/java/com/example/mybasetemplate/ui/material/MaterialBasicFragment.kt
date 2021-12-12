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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MaterialBasicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MaterialBasicFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentMaterialBasicBinding
    lateinit var materialViewModel: MaterialViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO DI로 주입
        materialViewModel = MaterialViewModel()

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    private fun setupUi() {
        with(binding) {


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
                            showToast("${it.first}, ${it.second}")
                        }
                    }.show(parentFragmentManager, null)
            }
        }
    }

    private fun subscrbeUi() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentMaterialBasicBinding.inflate(inflater, container, false)

        setupUi()
        subscrbeUi()

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MaterialBasicFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MaterialBasicFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}