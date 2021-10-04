package com.example.mybasetemplate.ui.intro

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mybasetemplate.data.IntroFeatureData

/**
 *  인트로 페이지의 기능 리스트를 보이는 Adapter
 */
class IntroAdapter(private val context: Context) : RecyclerView.Adapter<IntroAdapter.ViewHolder>() {
    var datas = mutableListOf<IntroFeatureData>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    fun setItems(list: List<IntroFeatureData>) {
        datas.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(parent.rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 0
    }
}