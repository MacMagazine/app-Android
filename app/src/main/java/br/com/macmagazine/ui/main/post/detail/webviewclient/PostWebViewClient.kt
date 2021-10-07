package br.com.macmagazine.ui.main.post.detail.webviewclient

import android.graphics.Bitmap
import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

private const val COMMENTS_PREFIX = "comments://"
private const val DISQUS_THREAD_CLASS_PREFIX = "#disqus_thread"
private const val PKPASS_EXTENSION = ".pkpass"
private const val SPACE_URL_ENCODING = "%20"

class PostWebViewClient(
    private val listener: WebViewListener
) : WebViewClient() {

    private var alreadyFinished = false

    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
        handler?.proceed()
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        listener.onContentStartLoad()
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        alreadyFinished = true
        listener.onContentFinishLoad()
    }

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest): Boolean {
        if (alreadyFinished) {
            val url = request.url.toString()

            when {
                url.contains(COMMENTS_PREFIX) -> {
                    val urlSanitized = url.replace(COMMENTS_PREFIX, "").replace(SPACE_URL_ENCODING, " ")
                    listener.openComments(urlSanitized)
                }
                url.contains(DISQUS_THREAD_CLASS_PREFIX) -> {
                    listener.openComments(url)
                }
                url.contains(PKPASS_EXTENSION) -> {
                    // openPassKit(url: url)
                }
                else -> {
                    listener.openExternalPage(url)
                }
            }

            return true
        } else {
            return false
        }
    }

    interface WebViewListener {
        fun openComments(url: String)
        fun openExternalPage(url: String)
        fun onContentStartLoad()
        fun onContentFinishLoad()
    }
}