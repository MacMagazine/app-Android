package br.com.macmagazine.ui.main.post.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import br.com.macmagazine.databinding.ItemPostBinding
import br.com.macmagazine.model.PostUi

class PostAdapter(
    private val listener: PostAdapterListener
) : PagingDataAdapter<PostUi, PostViewHolder>(PostDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position)?.let { post ->
            holder.bind(post)
        }
    }

    interface PostAdapterListener {
        fun onPostClick(post: PostUi)
    }
}