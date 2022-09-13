package com.fyrl29074.cat_gram.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fyrl29074.cat_gram.data.CatModel
import com.fyrl29074.cat_gram.databinding.CatImageItemBinding

class CatAdapter : PagingDataAdapter<CatModel, CatViewHolder>(DiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = CatImageItemBinding.inflate(LayoutInflater.from(parent.context))
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            item?.let {
                Glide
                    .with(image.context)
                    .load(it.url)
                    .into(image)
            }
        }
    }
}

class CatViewHolder(val binding: CatImageItemBinding) : RecyclerView.ViewHolder(binding.root)

class DiffUtilCallback : DiffUtil.ItemCallback<CatModel>() {
    override fun areItemsTheSame(oldItem: CatModel, newItem: CatModel): Boolean = false

    override fun areContentsTheSame(oldItem: CatModel, newItem: CatModel): Boolean = false
}
