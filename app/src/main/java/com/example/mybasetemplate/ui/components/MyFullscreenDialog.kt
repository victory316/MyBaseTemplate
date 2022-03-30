package com.example.mybasetemplate.ui.components

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

/**
 *  Full sized dialog의 구현체
 *
 *  @see https://developer.android.com/guide/topics/ui/dialogs#FullscreenDialog
 */
class MyFullscreenDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyFullscreenDialog()
    }
}
