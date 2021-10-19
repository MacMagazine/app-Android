package br.com.macmagazine.ui.main.post.detail.comments

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.content.res.AppCompatResources
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import br.com.macmagazine.BuildConfig
import br.com.macmagazine.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object PostCommentsCustomTab {

    fun open(url: String, context: Context) {
        val defaultColors = CustomTabColorSchemeParams.Builder()
            .setToolbarColor(Color.WHITE)
            .build()

        val builder = CustomTabsIntent.Builder()

        builder.setDefaultColorSchemeParams(defaultColors)

        AppCompatResources.getDrawable(context, R.drawable.ic_arrow_back)?.mutate()?.let {
            builder.setCloseButtonIcon(it.toBitmap())
        }

        val customTabsIntent = builder.build()

        val uri = createUri(url, context)

        uri?.let {
            customTabsIntent.intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            customTabsIntent.launchUrl(context, uri)
        }
    }

    private fun createUri(url: String, context: Context): Uri? {
        try {
            // Create an empty html file in external cache directory
            val redirect = File(context.externalCacheDir, "redirect.html")

            // Open and read local html file from asset folder
            var templateString = context.assets.open("comments.html").bufferedReader().use { it.readText() }

            // Replace urlComment
            templateString = templateString.replace("{{urlComment}}", url)

            // Write the content of file in redirect.html
            val fileOutputStream = FileOutputStream(redirect)
            fileOutputStream.write(templateString.toByteArray())

            // Get the uri of redirect.html using content provider
            val uri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", redirect)

            return uri

        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
    }
}