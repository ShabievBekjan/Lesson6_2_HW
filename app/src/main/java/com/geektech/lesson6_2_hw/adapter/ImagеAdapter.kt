package com.geektech.lesson6_2_hw.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.lesson6_2_hw.databinding.CardViewItemBinding

class ImageAdapter(private var list : ArrayList<Int> , private val selectedListener : ((uri : Int) -> Unit)? , private val deleteListener : ((uri : Int) -> Unit)?) : RecyclerView.Adapter<ImageAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(CardViewItemBinding.inflate(LayoutInflater.from(
            parent.context) ,
            parent ,
            false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ItemViewHolder(private var binding: CardViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(uri : Int) {
            binding.iv.setBackgroundResource(uri)
            binding.iv.setOnClickListener{
                if (binding.viewBackground.visibility == View.GONE) {
                    binding.viewBackground.visibility = View.VISIBLE
                    selectedListener?.let { it1 -> it1(uri) }
                } else {
                    binding.viewBackground.visibility = View.GONE
                    deleteListener?.let { it1 -> it1(uri) }
                }
            }

        }
    }
}