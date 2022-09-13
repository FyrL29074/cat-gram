package com.fyrl29074.cat_gram.presentation

import android.app.Activity
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fyrl29074.cat_gram.data.CatModel
import com.fyrl29074.cat_gram.databinding.CatImageItemBinding


class CatAdapter(
//    private val screenPixelDensity: Float?,
//    private val screenWidthInPixels: Float,
//    private val screenHeightInPixels: Float
) : PagingDataAdapter<CatModel, CatViewHolder>(DiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = CatImageItemBinding.inflate(LayoutInflater.from(parent.context))
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val item = getItem(position)

        val displaymetrics = DisplayMetrics()
//        (context as Activity).windowManager.defaultDisplay.getMetrics(displaymetrics)
        //if you need three fix imageview in width
        //if you need three fix imageview in width
        val devicewidth = displaymetrics.widthPixels / 3

        //if you need 4-5-6 anything fix imageview in height

        //if you need 4-5-6 anything fix imageview in height
        val deviceheight = displaymetrics.heightPixels / 4

        holder.binding.image.layoutParams.width = devicewidth

        //if you need same height as width you can set devicewidth in holder.image_view.getLayoutParams().height

        //if you need same height as width you can set devicewidth in holder.image_view.getLayoutParams().height
//        holder.image_view.getLayoutParams().height = deviceheight

//        if (screenPixelDensity == null)
//            return

//        val screenWidthInDp = convertPixelsToDp(screenWidthInPixels)
//        val screenHeightInDp = convertPixelsToDp(screenHeightInPixels)

        with(holder.binding) {
            item.let {
//                itemContainer.layoutParams = ViewGroup.LayoutParams(
//                    100,
//                    100
//                )

                Glide
                    .with(image.context)
                    .load(it!!.url)
                    .into(image)
            }
        }
    }

//    private fun convertPixelsToDp(pixels: Float): Int {
//        if (screenPixelDensity == null)
//            return 0
//
//        val dpValue = pixels / screenPixelDensity
//        return dpValue.toInt()
//    }
}

class CatViewHolder(val binding: CatImageItemBinding) : RecyclerView.ViewHolder(binding.root)

class DiffUtilCallback : DiffUtil.ItemCallback<CatModel>() {
    override fun areItemsTheSame(oldItem: CatModel, newItem: CatModel): Boolean = false

    override fun areContentsTheSame(oldItem: CatModel, newItem: CatModel): Boolean = false
}
