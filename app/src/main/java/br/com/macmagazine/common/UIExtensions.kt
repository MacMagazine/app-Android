package br.com.macmagazine.common

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadFromUrl(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}