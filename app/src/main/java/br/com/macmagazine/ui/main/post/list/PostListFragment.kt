package br.com.macmagazine.ui.main.post.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.macmagazine.databinding.FragmentPostListBinding
import br.com.macmagazine.model.Post
import br.com.macmagazine.ui.main.post.list.adapter.PostAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostListFragment : Fragment(), PostAdapter.PostAdapterListener {

    private val viewModel: PostListViewModel by viewModel()

    private lateinit var binding: FragmentPostListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPostListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    override fun onPostClick(post: Post) {
        TODO("Not yet implemented")
    }

    private fun setupObservers() {
        viewModel.posts.observe(viewLifecycleOwner, Observer(::setupRecyclerView))
    }

    private fun setupRecyclerView(posts: List<Post>) {
        val categoryAdapter = PostAdapter(posts, this@PostListFragment)
        with(binding.rvPosts) {
            adapter = categoryAdapter

            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}