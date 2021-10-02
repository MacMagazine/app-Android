package br.com.macmagazine.route

import androidx.navigation.NavController
import br.com.macmagazine.model.PostUi
import br.com.macmagazine.ui.main.post.list.PostListFragmentDirections

class ScreenRouter(private val navController: NavController) {

    fun fromPostListToPostDetail(item: PostUi.PostItemUi) {
        navController.navigate(PostListFragmentDirections.actionPostListFlowToPostDetailActivity(item))
    }
}