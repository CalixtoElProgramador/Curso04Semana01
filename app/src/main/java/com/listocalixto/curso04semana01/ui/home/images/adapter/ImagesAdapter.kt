package com.listocalixto.curso04semana01.ui.home.images.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.listocalixto.curso04semana01.core.BaseViewHolder
import com.listocalixto.curso04semana01.data.model.media.Media
import com.listocalixto.curso04semana01.databinding.ItemMediaBinding

class ImagesAdapter(
    private val mediaList: List<Media>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnItemClickListener {
        fun onItemClick(media: Media)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = RecyclerViewHolder(itemBinding, parent.context)
        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION } ?: return@setOnClickListener
            onItemClickListener.onItemClick(mediaList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder) {
            is RecyclerViewHolder -> {
                holder.bind(mediaList[position])
            }
        }
    }

    override fun getItemCount(): Int = mediaList.size

    private inner class RecyclerViewHolder(
        val binding: ItemMediaBinding,
        val context: Context
    ) : BaseViewHolder<Media>(binding.root) {
        override fun bind(item: Media) {
            binding.captionMedia.text = item.caption
            binding.dateMedia.text = item.timestamp
            binding.typeMedia.text = item.media_type
            Glide.with(context).load(item.media_url).centerCrop().into(binding.imageMedia)
        }
    }

}