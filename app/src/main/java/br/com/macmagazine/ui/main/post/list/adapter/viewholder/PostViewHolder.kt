package br.com.macmagazine.ui.main.post.list.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import br.com.macmagazine.common.loadFromUrl
import br.com.macmagazine.common.setFormattingText
import br.com.macmagazine.databinding.ItemPostBinding
import br.com.macmagazine.model.PostUi
import br.com.macmagazine.ui.main.post.list.adapter.PostAdapter

class PostViewHolder(
    private val binding: ItemPostBinding,
    private val listener: PostAdapter.PostAdapterListener
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PostUi.PostItemUi) {
        binding.tvPostTitle.text = item.title
        binding.tvPostDescription.setFormattingText(item.description)
        binding.ivPostImage.loadFromUrl(item.imageUrl)

        binding.cvContainer.setOnClickListener {
            listener.onPostClick(item)
        }
    }
}