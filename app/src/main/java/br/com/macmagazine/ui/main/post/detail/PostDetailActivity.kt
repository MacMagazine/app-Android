package br.com.macmagazine.ui.main.post.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import br.com.macmagazine.common.extensions.setupToolbarWithBackButton
import br.com.macmagazine.databinding.ActivityPostDetailBinding
import br.com.macmagazine.ui.main.post.detail.webviewclient.CustomWebViewClient
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PostDetailActivity : AppCompatActivity() {

    private val args: PostDetailActivityArgs by navArgs()
    private val viewModel: PostDetailViewModel by viewModel {
        parametersOf(args)
    }

    private lateinit var binding: ActivityPostDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupToolbarWithBackButton(binding.includeToolbar.toolbar)

        setupObservables()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupObservables() {
        viewModel.detailUrl.observe(this) { loadUrl(it) }
    }

    private fun loadUrl(url: String) {
        binding.wvPostDetailContainer.webViewClient = CustomWebViewClient()
        binding.wvPostDetailContainer.loadUrl(url)
    }
}