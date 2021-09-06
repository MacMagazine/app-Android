package br.com.macmagazine.common

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadFromUrl(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}