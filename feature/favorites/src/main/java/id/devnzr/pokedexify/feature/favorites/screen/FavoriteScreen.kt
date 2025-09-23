package id.devnzr.pokedexify.feature.favorites.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun FavoriteScreen(state: FavoriteState, onEvent: (FavoriteEvent) -> Unit) {
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
        if (state.favorites.isEmpty()) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(text = "No Favorites Yet", fontSize = 20.sp)
            }
        } else {
            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                items(state.favorites) { pokemon ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable { onEvent(FavoriteEvent.OnToggleFavorite(pokemon)) }
                            .background(Color.LightGray, RoundedCornerShape(8.dp))
                            .padding(16.dp)
                    ) {
                        AsyncImage(
                            model = pokemon.imageUrl,
                            contentDescription = pokemon.name,
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(text = pokemon.name, fontSize = 20.sp)
                    }
                }
            }
        }
    }
}
