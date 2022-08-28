package com.example.appiniontest.ui.images.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.Navigation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appiniontest.R
import com.example.appiniontest.databinding.ItemImagesBinding
import com.example.appiniontest.ui.images.model.ImagesResponse


class ImageAdapter: PagingDataAdapter<ImagesResponse, ImageAdapter.ViewHolder>(ImageComparator) {

    class ViewHolder(val binding: ItemImagesBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = getItem(position)!!
        holder.binding.image = image.urls

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("image_url", image.urls.full)
            Navigation.findNavController(holder.itemView).navigate(
                R.id.action_imagesFragment_to_fullImageFragment, bundle
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listItemBinding = ItemImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(listItemBinding)
    }

    object ImageComparator: DiffUtil.ItemCallback<ImagesResponse>() {
        override fun areItemsTheSame(oldItem: ImagesResponse, newItem: ImagesResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ImagesResponse, newItem: ImagesResponse): Boolean {
            return oldItem == newItem
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageUrl(imgView: ImageView, imgUrl: String?) {

            imgUrl?.let {
                Glide.with(imgView.context)
                    .load(imgUrl)
                    .into(imgView)
            }
        }
    }
}