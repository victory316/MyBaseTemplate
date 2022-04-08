package com.example.mybasetemplate.ui.intro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mybasetemplate.data.IntroFeatureData
import com.example.mybasetemplate.databinding.ItemIntroFeatureBinding
import com.example.mybasetemplate.presentation.IntroViewModel

/**
 *  인트로 페이지의 기능 리스트를 보이는 Adapter
 */
class IntroAdapter(private val viewModel: IntroViewModel) :
    RecyclerView.Adapter<IntroAdapter.ViewHolder>() {
    var datas = mutableListOf<IntroFeatureData>()

    inner class ViewHolder(private val binding: ItemIntroFeatureBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: IntroFeatureData) {
            binding.introFeature = item.feature
            binding.root.setOnClickListener {
                viewModel.openFunction(item.feature)
            }
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
