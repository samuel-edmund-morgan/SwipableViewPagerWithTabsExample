package com.example.swipableviewpagerwithtabsexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swipableviewpagerwithtabsexample.databinding.PagerViewHolderBinding

class PagerAdapter(val images : List<Int>) : RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {
    inner class PagerViewHolder(val binding: PagerViewHolderBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder = PagerViewHolder(PagerViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount(): Int = images.size
    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) = holder.binding.ivHolder.setImageResource(images[position])
}