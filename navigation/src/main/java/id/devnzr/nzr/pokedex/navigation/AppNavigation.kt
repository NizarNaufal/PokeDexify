package id.devnzr.nzr.pokedex.navigation

import android.content.Context

interface AppNavigation {
    fun navigateToMain(context: Context)
    fun navigateToLogin(context: Context)
    fun navigateToDetail(context: Context, name: String)
}