package br.com.macmagazine.ui.main.post.list.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import br.com.macmagazine.common.extensions.loadFromUrl
import br.com.macmagazine.databinding.ItemPostHighlightedBinding
import br.com.macmagazine.model.PostUi
import br.com.macmagazine.ui.main.post.list.adapter.PostAdapter

class PostHighlightedViewHolder(
    private val binding: ItemPostHighlightedBinding,
    private val listener: PostAdapter.PostAdapterListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostUi.PostItemUi) {
        binding.tvPostTitle.text = item.title
        binding.ivPostImage.loadFromUrl(item.imageUrl)

        binding.cvContainer.setOnClickListener {
            listener.onPostClick(item)
        }
    }
}