package br.com.macmagazine.ui.main.post.list.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import br.com.macmagazine.databinding.ItemPostHeaderDateBinding
import br.com.macmagazine.model.PostUi

class PostHeaderViewHolder(
    private val binding: ItemPostHeaderDateBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostUi.PostHeaderDateUi) {
        binding.tvPostHeader.text = item.description
    }
}