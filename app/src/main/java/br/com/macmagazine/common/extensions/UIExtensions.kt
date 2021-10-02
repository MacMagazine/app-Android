package br.com.macmagazine.common.extensions

import android.os.Build
import android.text.Html
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadFromUrl(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}

fun TextView.setFormattingText(s: String) {
    text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(s, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(s)
    }
}