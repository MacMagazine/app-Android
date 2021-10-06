package br.com.macmagazine.ui.main.post.detail.webviewclient

import android.graphics.Bitmap
import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient

class CustomWebViewClient(
    private val listener: WebViewListener
): WebViewClient() {

    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
        handler?.proceed()
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        listener.onContentStartLoad()
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
//        view?.let {
//            manipulateElementsOnPage(view)
//        }

        listener.onContentFinishLoad()
    }

//    private fun manipulateElementsOnPage(webView: WebView) {
//        val scripts = listOf(
////            imageScriptSource,
////            disableGalleryScriptSource,
////            disableNewGalleryScriptSource,
////            commentsScriptSource,
//            removeHeader
//        )
//
////        scripts.forEach { script ->
////            val injectedJs = "javascript:(function(){$script})()";
////            webView.loadUrl(injectedJs)
////        }
//    }

    interface WebViewListener {
        fun onContentStartLoad()
        fun onContentFinishLoad()
    }
}