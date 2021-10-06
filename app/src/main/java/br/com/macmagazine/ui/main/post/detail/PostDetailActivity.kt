package br.com.macmagazine.ui.main.post.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import br.com.macmagazine.BuildConfig
import br.com.macmagazine.R
import br.com.macmagazine.common.extensions.setupToolbarWithBackButton
import br.com.macmagazine.common.helpers.ShareHelper
import br.com.macmagazine.databinding.ActivityPostDetailBinding
import br.com.macmagazine.model.PostUi
import br.com.macmagazine.ui.main.post.detail.webviewclient.PostWebViewClient
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PostDetailActivity : AppCompatActivity(), PostWebViewClient.WebViewListener {

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

        setupWebView()
        setupObservables()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.shared_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.share -> onShareClick()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onContentStartLoad() {
        binding.wvPostDetailContainer.visibility = View.INVISIBLE
        binding.progress.show()
    }

    override fun onContentFinishLoad() {
        binding.wvPostDetailContainer.visibility = View.VISIBLE
        binding.progress.hide()
    }

    private fun setupWebView() {
        WebView.setWebContentsDebuggingEnabled(BuildConfig.DEBUG)
        binding.wvPostDetailContainer.settings.javaScriptEnabled = true
        binding.wvPostDetailContainer.settings.defaultTextEncodingName = "utf-8"
        binding.wvPostDetailContainer.settings.userAgentString = "MacMagazine"
        binding.wvPostDetailContainer.webViewClient = PostWebViewClient(this)
    }

    private fun setupObservables() {
        viewModel.detailUrl.observe(this) { url ->
            binding.wvPostDetailContainer.loadUrl(url)
        }

        viewModel.sharePost.observe(this, ::sharePost)
    }

    private fun onShareClick() {
        viewModel.onShareClick()
    }

    private fun sharePost(post: PostUi.PostItemUi) {
       ShareHelper(this).shareLink(ShareHelper.SharedLink(post.title, post.detailUrl))
    }

}