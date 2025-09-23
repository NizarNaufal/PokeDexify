package id.devnzr.nzr.pokedex.navigation

interface Route {
    val route: String
        get() = this::class.simpleName!!
}