package br.com.macmagazine.ui.main.post.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.macmagazine.model.Post

class PostListViewModel : ViewModel() {

    val posts = MutableLiveData<List<Post>>(
        listOf(
            Post("Title", "Description", "https://cdn.cdkeys.com/700x700/media/catalog/product/t/h/the_legend_of_zelda_-_breath_of_the_wild_switch.jpg")
        )
    )
}