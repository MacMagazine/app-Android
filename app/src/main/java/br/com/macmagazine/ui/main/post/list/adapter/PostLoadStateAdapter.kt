package br.com.macmagazine.ui.main.post.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import br.com.macmagazine.databinding.ItemLoadStateBinding
import br.com.macmagazine.ui.main.post.list.adapter.viewholder.PostLoadStateViewHolder

typealias PostLoadStateAdapterRetry = () -> Unit

class PostLoadStateAdapter(
    private val retry: PostLoadStateAdapterRetry
) : LoadStateAdapter<PostLoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): PostLoadStateViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLoadStateBinding.inflate(inflater, parent, false)
        return PostLoadStateViewHolder(binding, retry)
    }

    override fun onBindViewHolder(holder: PostLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }
}