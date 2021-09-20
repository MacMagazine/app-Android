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

    fun bind(post: PostUi) {
        binding.tvPostTitle.text = post.title
        binding.tvPostDescription.setFormattingText(post.description)
        binding.ivPostImage.loadFromUrl(post.imageUrl)

        binding.cvContainer.setOnClickListener {
            listener.onPostClick(post)
        }
    }
}