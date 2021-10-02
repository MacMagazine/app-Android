package br.com.macmagazine.common.resource

import android.content.Context

class AndroidResource(private val context: Context): ResourceProvider {

    override fun getString(resId: Int): String = context.getString(resId)
}