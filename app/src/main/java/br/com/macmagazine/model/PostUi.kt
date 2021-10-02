package br.com.macmagazine.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

sealed class PostUi : Parcelable {
    @Parcelize data class PostItemUi(
        val guid: String,
        val title: String,
        val description: String,
        val imageUrl: String,
        val detailUrl: String,
        val highlighted: Boolean,
        val pubDate: LocalDate
    ) : PostUi()

    @Parcelize data class PostSeparatorDateUi(
        val description: String
    ) : PostUi()
}