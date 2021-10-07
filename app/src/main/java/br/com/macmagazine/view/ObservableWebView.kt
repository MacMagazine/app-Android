package br.com.macmagazine.view

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

class ObservableWebView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {

    var onScrollChangedCallback: OnScrollChangeListener? = null

    override fun onScrollChanged(
        currentHorizontalScroll: Int,
        currentVerticalScroll: Int,
        oldHorizontalScroll: Int,
        oldcurrentVerticalScroll: Int
    ) {
        super.onScrollChanged(currentHorizontalScroll, currentVerticalScroll, oldHorizontalScroll, oldcurrentVerticalScroll)

        onScrollChangedCallback?.onScrollChanged(currentHorizontalScroll, currentVerticalScroll, oldHorizontalScroll, oldcurrentVerticalScroll)
    }

    interface OnScrollChangeListener {
        fun onScrollChanged(currentHorizontalScroll: Int, currentVerticalScroll: Int, oldHorizontalScroll: Int, oldcurrentVerticalScroll: Int)
    }
}