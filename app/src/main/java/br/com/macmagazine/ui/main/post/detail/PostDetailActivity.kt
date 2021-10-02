package br.com.macmagazine.ui.main.post.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.macmagazine.common.extensions.setupToolbarWithBackButton
import br.com.macmagazine.databinding.ActivityPostDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostDetailActivity : AppCompatActivity() {

    private val viewModel: PostDetailViewModel by viewModel()

    private lateinit var binding: ActivityPostDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupToolbarWithBackButton(binding.includeToolbar.toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}