package id.devnzr.pokedexify.navigation

import android.content.Context
import android.content.Intent
import id.devnzr.pokedexify.feature.login.screen.LoginActivity
import id.devnzr.pokedexify.screen.MainActivity
import id.devnzr.nzr.pokedex.navigation.AppNavigation
import id.devnzr.pokedexify.feature.detail.screen.DetailActivity

class AppNavigatorImpl : AppNavigation {
    override fun navigateToMain(context: Context) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        context.startActivity(intent)
    }

    override fun navigateToLogin(context: Context) {
        val intent = Intent(context, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        context.startActivity(intent)
    }

    override fun navigateToDetail(context: Context, name: String) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.NAME, name)
        context.startActivity(intent)
    }

}