package br.com.macmagazine.ui.main.post.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.macmagazine.databinding.ItemPostBinding
import br.com.macmagazine.databinding.ItemPostHighlightedBinding
import br.com.macmagazine.model.PostUi
import br.com.macmagazine.ui.main.post.list.adapter.viewholder.PostHighlightedViewHolder

class PostAdapter(
    private val listener: PostAdapterListener
) : PagingDataAdapter<PostUi, RecyclerView.ViewHolder>(PostDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if (viewType == VIEW_TYPE_HIGHLIGHTED) {
            val binding = ItemPostHighlightedBinding.inflate(inflater, parent, false)
            PostHighlightedViewHolder(binding, listener)
        } else {
            val binding = ItemPostBinding.inflate(inflater, parent, false)
            PostViewHolder(binding, listener)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let { post ->
            if (holder is PostHighlightedViewHolder) {
                holder.bind(post)
            } else if (holder is PostViewHolder) {
                holder.bind(post)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position)?.highlighted == true) {
            VIEW_TYPE_HIGHLIGHTED
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    interface PostAdapterListener {
        fun onPostClick(post: PostUi)
    }

    companion object {
        private const val VIEW_TYPE_NORMAL = 1
        private const val VIEW_TYPE_HIGHLIGHTED = 2
    }
}