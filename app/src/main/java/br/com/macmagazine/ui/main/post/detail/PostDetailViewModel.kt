package br.com.macmagazine.ui.main.post.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostDetailViewModel(private val args: PostDetailActivityArgs) : ViewModel() {

    val detailUrl: LiveData<String> = MutableLiveData(args.post.detailUrl)

}