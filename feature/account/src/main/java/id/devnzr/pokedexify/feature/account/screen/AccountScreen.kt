package id.devnzr.pokedexify.feature.account.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import id.devnzr.pokedexify.core.uikit.theme.Black700
import id.devnzr.pokedexify.core.uikit.theme.Black80
import id.devnzr.pokedexify.core.uikit.theme.Black800

@Composable
fun AccountScreen(state: AccountState) {
    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .height(67.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "https://static.vecteezy.com/system/resources/previews/006/487/917/original/man-avatar-icon-free-vector.jpg",
                modifier = Modifier.size(44.dp),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(12.dp))
            Text(text = "Hi! ${state.resultUser.data}", style = MaterialTheme.typography.titleMedium)
        }
        HorizontalDivider(color = Black80)
        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp)
        ) {
            Text(
                "Account Information",
                style = MaterialTheme.typography.headlineMedium,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Name",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = Black800
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                state.resultUser.data.orEmpty(),
                style = MaterialTheme.typography.bodyMedium,
                color = Black700
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Email",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = Black800
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                "testing@test.com",
                style = MaterialTheme.typography.bodyMedium,
                color = Black700
            )
        }
    }
}

@Preview(name = "Account Screen", showBackground = true)
@Composable
private fun PreviewProfileTab() {
    MaterialTheme {
        AccountScreen(state = AccountState())
    }
}
