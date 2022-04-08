package com.example.mybasetemplate.ui.material

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mybasetemplate.data.IntroFeatureData
import com.example.mybasetemplate.databinding.ItemIntroFeatureBinding

class MaterialPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    var datas = mutableListOf<Fragment>()

    fun setFragments(vararg fragments: Fragment) {
        datas.addAll(fragments)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun createFragment(position: Int): Fragment {
        return datas[position]
    }
}
