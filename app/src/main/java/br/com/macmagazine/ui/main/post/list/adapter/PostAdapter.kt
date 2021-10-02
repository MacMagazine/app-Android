package br.com.macmagazine.ui.main.post.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.macmagazine.databinding.ItemPostBinding
import br.com.macmagazine.databinding.ItemPostHeaderDateBinding
import br.com.macmagazine.databinding.ItemPostHighlightedBinding
import br.com.macmagazine.model.PostUi
import br.com.macmagazine.ui.main.post.list.adapter.viewholder.PostHeaderViewHolder
import br.com.macmagazine.ui.main.post.list.adapter.viewholder.PostHighlightedViewHolder
import br.com.macmagazine.ui.main.post.list.adapter.viewholder.PostViewHolder

class PostAdapter(
    private val listener: PostAdapterListener
) : PagingDataAdapter<PostUi, RecyclerView.ViewHolder>(PostDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                val binding = ItemPostHeaderDateBinding.inflate(inflater, parent, false)
                PostHeaderViewHolder(binding)
            }
            VIEW_TYPE_HIGHLIGHTED -> {
                val binding = ItemPostHighlightedBinding.inflate(inflater, parent, false)
                PostHighlightedViewHolder(binding, listener)
            }
            else -> {
                val binding = ItemPostBinding.inflate(inflater, parent, false)
                PostViewHolder(binding, listener)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is PostUi.PostSeparatorDateUi -> {
                if (holder is PostHeaderViewHolder) {
                    holder.bind(item)
                }
            }
            is PostUi.PostItemUi -> {
                if (holder is PostHighlightedViewHolder) {
                    holder.bind(item)
                } else if (holder is PostViewHolder) {
                    holder.bind(item)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (val item = getItem(position)) {
            is PostUi.PostSeparatorDateUi -> VIEW_TYPE_HEADER
            is PostUi.PostItemUi -> {
                if (item.highlighted) {
                    VIEW_TYPE_HIGHLIGHTED
                } else {
                    VIEW_TYPE_NORMAL
                }
            }
            null -> throw UnsupportedOperationException("Unknown view")
        }
    }

    interface PostAdapterListener {
        fun onPostClick(item: PostUi.PostItemUi)
    }

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_NORMAL = 1
        private const val VIEW_TYPE_HIGHLIGHTED = 2
    }
}