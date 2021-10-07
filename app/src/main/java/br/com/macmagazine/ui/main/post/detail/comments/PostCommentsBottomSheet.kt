package br.com.macmagazine.ui.main.post.detail.comments

import android.content.Context
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import br.com.macmagazine.R
import br.com.macmagazine.view.ObservableWebView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class PostCommentsBottomSheet(context: Context) : FrameLayout(context) {

    private val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(context)
    private var currentWebViewScrollY = 0

    private lateinit var cloneIcon: AppCompatImageView
    private lateinit var webView: ObservableWebView

    private var urlComment: String = ""

    init {
        inflateLayout(context)
        setupBottomSheetBehaviour()
        setupView()

    }

    fun show(url: String) {
        urlComment = url

        setupWebView()

        bottomSheetDialog.show()
    }

    fun close() {
        bottomSheetDialog.dismiss()
    }

    private fun inflateLayout(context: Context) {
        inflate(context, R.layout.bottom_sheet_comments, this)

        bottomSheetDialog.setContentView(this)

        bottomSheetDialog.window?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            ?.setBackgroundResource(android.R.color.transparent);
    }

    private fun setupView() {
        cloneIcon = findViewById(R.id.ivHeaderCloseIcon)
        webView = findViewById(R.id.wvCommentsContainer)

        cloneIcon.setOnClickListener { close() }
    }

    private fun setupBottomSheetBehaviour() {
        (parent as? View)?.let { view ->
            BottomSheetBehavior.from(view).let { behaviour ->
                behaviour.addBottomSheetCallback(object :
                    BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {

                    }

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        if (newState == BottomSheetBehavior.STATE_DRAGGING && currentWebViewScrollY > 0) {
                            // this is where we check if webview can scroll up or not and based on that we let BottomSheet close on scroll down
                            behaviour.setState(BottomSheetBehavior.STATE_EXPANDED);
                        } else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                            close()
                        }
                    }
                })
            }
        }
    }

    private fun setupWebView() {
        webView.loadUrl("file:///android_asset/comments.html")
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = CommentsClient()

        webView.onScrollChangedCallback = object : ObservableWebView.OnScrollChangeListener {
            override fun onScrollChanged(
                currentHorizontalScroll: Int,
                currentVerticalScroll: Int,
                oldHorizontalScroll: Int,
                oldcurrentVerticalScroll: Int
            ) {
                currentWebViewScrollY = currentVerticalScroll
            }
        }
    }

    private inner class CommentsClient : WebViewClient() {
        override fun onPageFinished(web: WebView, url: String?) {
            super.onPageFinished(web, url)

            val s = buildString {
                append("var disqus_identifier = '${urlComment}';")
                append("var disqus_shortname = 'macmagazinecombr';")
                append("(function() { var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true; dsq.src = 'https://macmagazinecombr.disqus.com/embed.js';")
                append("(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq); })();")
            }

            web.evaluateJavascript(s, null)
        }
    }
}