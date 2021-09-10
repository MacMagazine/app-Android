package br.com.macmagazine.ui.main.post.list.adapter

import androidx.recyclerview.widget.DiffUtil
import br.com.macmagazine.model.PostUi

class PostDiffCallBack : DiffUtil.ItemCallback<PostUi>(){
    override fun areItemsTheSame(oldItem: PostUi, newItem: PostUi): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: PostUi, newItem: PostUi): Boolean {
        return oldItem == newItem
    }
}