package id.devnzr.pokedexify.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import id.devnz.pokdexify.feature.home.screen.HomeNavigation
import id.devnz.pokdexify.feature.home.screen.homeScreen
import id.devnzr.pokedexify.R
import id.devnzr.pokedexify.feature.account.screen.AccountNavigation
import id.devnzr.pokedexify.feature.account.screen.accountScreen

@Composable
fun MainHost() {
    val navController = rememberNavController()
    val activity = LocalContext.current as MainActivity

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeNavigation::class.qualifiedName.orEmpty(),
            modifier = Modifier.padding(innerPadding).windowInsetsPadding(WindowInsets.systemBars)
        ) {
            homeScreen(
                onNavigateDetail = { name ->
                    activity.handleNavigateToDetail(name)
                }
            )
            accountScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation(backgroundColor = Color.White) {
        BottomNavigationItem(
            selected = currentDestination(navController) == HomeNavigation::class.simpleName.orEmpty(),
            onClick = { navController.navigate(HomeNavigation::class.qualifiedName.orEmpty()) },
            label = { Text("Home") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_pokedox_on),
                    contentDescription = "Home"
                )
            }
        )
        BottomNavigationItem(
            selected = currentDestination(navController) == AccountNavigation::class.simpleName.orEmpty(),
            onClick = { navController.navigate(AccountNavigation::class.qualifiedName.orEmpty()) },
            label = { Text("Account") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile_on),
                    contentDescription = "Account"
                )
            }
        )
    }
}

@Composable
fun currentDestination(navController: NavHostController): String? {
    return navController.currentBackStackEntry?.destination?.route
}