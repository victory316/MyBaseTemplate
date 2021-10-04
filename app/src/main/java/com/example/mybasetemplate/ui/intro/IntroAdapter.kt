package com.example.mybasetemplate.ui.intro

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mybasetemplate.R
import com.example.mybasetemplate.data.IntroFeatureData
import com.example.mybasetemplate.databinding.ItemIntroFeatureBinding
import com.example.mybasetemplate.enums.IntroFeatures

/**
 *  인트로 페이지의 기능 리스트를 보이는 Adapter
 */
class IntroAdapter(private val context: Context) : RecyclerView.Adapter<IntroAdapter.ViewHolder>() {
    var datas = mutableListOf<IntroFeatureData>()

    inner class ViewHolder(private val binding: ItemIntroFeatureBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: IntroFeatureData) {
            binding.introFeature = item.feature
        }
    }

    fun setItems(list: List<IntroFeatureData>) {
        datas.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemIntroFeatureBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}