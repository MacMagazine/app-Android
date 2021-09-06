package br.com.macmagazine.ui.main.post.list.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.macmagazine.common.loadFromUrl
import br.com.macmagazine.databinding.ItemPostBinding
import br.com.macmagazine.model.Post

class PostViewHolder(
    private val binding: ItemPostBinding,
    private val listener: PostAdapter.PostAdapterListener
): RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        binding.tvPostTitle.text = post.title
        binding.tvPostDescription.text = post.description
        binding.ivPostImage.loadFromUrl(post.imageUrl)

        binding.cvContainer.setOnClickListener {
            listener.onPostClick(post)
        }
    }
}