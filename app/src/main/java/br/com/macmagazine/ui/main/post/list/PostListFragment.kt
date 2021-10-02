package br.com.macmagazine.ui.main.post.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.macmagazine.databinding.FragmentPostListBinding
import br.com.macmagazine.model.PostUi
import br.com.macmagazine.ui.main.post.list.adapter.PostAdapter
import br.com.macmagazine.ui.main.post.list.adapter.PostLoadStateAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostListFragment : Fragment(), PostAdapter.PostAdapterListener {

    private val viewModel: PostListViewModel by viewModel()

    private lateinit var binding: FragmentPostListBinding

    private lateinit var postAdapter: PostAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPostListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSwipeRefresh()
        setupRecyclerView()
        collectUiState()
    }

    override fun onPostClick(post: PostUi) {
        TODO("Not yet implemented")
    }

    private fun setupSwipeRefresh() {
        binding.srlSwipePostsContainer.setOnRefreshListener {
            viewModel.invalidatePostsDataSource()
        }
    }

    private fun setupRecyclerView() {
        postAdapter = PostAdapter(this@PostListFragment)
        with(binding.rvPosts) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)

            postAdapter.withLoadStateFooter(
                footer = PostLoadStateAdapter { postAdapter.retry() }
            )

            adapter = postAdapter
        }
    }

    private fun collectUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPosts().collectLatest { movies ->
                binding.srlSwipePostsContainer.isRefreshing = false
                postAdapter.submitData(movies)
            }
        }
    }
}