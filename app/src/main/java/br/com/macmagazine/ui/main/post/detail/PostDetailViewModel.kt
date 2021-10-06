package br.com.macmagazine.ui.main.post.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.macmagazine.model.PostUi

class PostDetailViewModel(private val args: PostDetailActivityArgs) : ViewModel() {

    val detailUrl: LiveData<String> = MutableLiveData(args.post.detailUrl)

    val sharePost = MutableLiveData<PostUi.PostItemUi>()

    fun onShareClick() {
       sharePost.value = args.post
    }
}