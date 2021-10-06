package br.com.macmagazine.common.helpers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class ShareHelper(private val activity: AppCompatActivity) {

    fun shareLink(sharedLink: SharedLink) {
        val shareIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "${sharedLink.title}\n${sharedLink.link}")
            type = "text/plain"
        }
        activity.startActivity(Intent.createChooser(shareIntent, null))
    }

    class SharedLink(
        val title: String,
        val link: String
    )
}