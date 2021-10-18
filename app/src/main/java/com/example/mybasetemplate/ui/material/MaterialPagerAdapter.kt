package com.example.mybasetemplate.ui.material

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mybasetemplate.data.IntroFeatureData
import com.example.mybasetemplate.databinding.ItemIntroFeatureBinding

class MaterialPagerAdapter() :
    RecyclerView.Adapter<MaterialPagerAdapter.ViewHolder>() {
    var datas = mutableListOf<IntroFeatureData>()

    inner class ViewHolder(private val binding: ItemIntroFeatureBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: IntroFeatureData) {

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