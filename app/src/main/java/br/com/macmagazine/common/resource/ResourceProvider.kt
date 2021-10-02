package br.com.macmagazine.common.resource

interface ResourceProvider {

    fun getString(resId: Int): String

}