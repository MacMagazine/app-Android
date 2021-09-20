package br.com.macmagazine.ui.main.post.list.adapter.viewholder

import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import br.com.macmagazine.databinding.ItemLoadStateBinding
import br.com.macmagazine.ui.main.post.list.adapter.PostLoadStateAdapterRetry

class PostLoadStateViewHolder(
    private val binding: ItemLoadStateBinding,
    private val retry: PostLoadStateAdapterRetry
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(loadState: LoadState) {
        binding.btnLoadStateRetry.isVisible = loadState !is LoadState.Loading
        binding.tvLoadStateErrorMessage.isVisible = loadState !is LoadState.Loading
        binding.pbLoadStateProgress.isVisible = loadState is LoadState.Loading

        if (loadState is LoadState.Error){
            binding.tvLoadStateErrorMessage.text = loadState.error.localizedMessage
        }

        binding.btnLoadStateRetry.setOnClickListener {
            retry.invoke()
        }
    }
}