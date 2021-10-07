package br.com.macmagazine.common.helpers

import android.app.Activity
import android.graphics.Color
import android.net.Uri
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent

class CustomTabHelper(private val activity: Activity) {

    fun openLink(url: String) {
        val defaultColors = CustomTabColorSchemeParams.Builder()
            .setToolbarColor(Color.WHITE)
            .build()

        val builder = CustomTabsIntent.Builder()
        builder.setSession()
        builder.setDefaultColorSchemeParams(defaultColors)

        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(activity, Uri.parse(url));
    }
}