package br.com.macmagazine.common.helpers

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.res.ResourcesCompat
import br.com.macmagazine.R

class CustomTabHelper(private val activity: AppCompatActivity) {

    fun openLink(url: String) {
        val color = ResourcesCompat.getColor(activity.resources, R.color.light_blue_600, null)

        val defaultColors = CustomTabColorSchemeParams.Builder()
            .setToolbarColor(color)
            .build()

        val builder = CustomTabsIntent.Builder()
        builder.setDefaultColorSchemeParams(defaultColors)

        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(activity, Uri.parse(url));
    }
}