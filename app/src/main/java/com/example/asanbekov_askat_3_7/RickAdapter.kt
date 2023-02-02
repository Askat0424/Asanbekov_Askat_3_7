package com.example.asanbekov_askat_3_7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.asanbekov_askat_3_7.databinding.ItemRickBinding


class RickAdapter(val RickList: ArrayList<User>, val onClick:(position:Int) -> Unit): Adapter<RickAdapter.RickViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickViewHolder {
        return RickViewHolder(ItemRickBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RickViewHolder, position: Int) {
        holder.bind()

    }

    override fun getItemCount() = RickList.size


    inner class RickViewHolder(private val binding: ItemRickBinding): RecyclerView.ViewHolder(binding.root){
        fun bind() {
            val item = RickList[adapterPosition]
            binding.apply {
                tvName.text = item.name
                tvStatus.text = item.status
                item.image?.let { image.setImageResource(it) }
            }

            itemView.setOnClickListener {
                onClick(adapterPosition)
            }
        }
    }
}