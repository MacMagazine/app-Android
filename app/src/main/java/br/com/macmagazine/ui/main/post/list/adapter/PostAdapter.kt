package br.com.macmagazine.ui.main.post.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.macmagazine.databinding.ItemPostBinding
import br.com.macmagazine.model.Post

class PostAdapter(
    private val dataSet: List<Post>,
    private val listener: PostAdapterListener
) : RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataSet.size

    interface PostAdapterListener {
        fun onPostClick(post: Post)
    }
}