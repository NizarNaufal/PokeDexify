package id.devnzr.pokedexify.feature.login.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.devnzr.pokedexify.core.extension.OnEvent
import id.devnzr.pokedexify.feature.login.screen.components.BackgroundAppBar
import id.devnzr.pokedexify.feature.login.screen.components.CustomFilledButton
import id.devnzr.pokedexify.feature.login.screen.components.CustomOutlinedTextField

@Composable
fun LoginScreen(state: LoginState, onEvent: OnEvent) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(color = Color.White),
            ) {
                IconButton(
                    onClick = {
                        onEvent(LoginEvent.OnNavigateBack)
                    },
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowLeft,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                }

                Text(
                    text = "Welcome Back",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 36.sp,
                        fontFamily = FontFamily(Font(id.devnzr.pokedexify.core.uikit.R.font.roboto_regular))
                    ),
                )

                CustomOutlinedTextField(text = state.userName, placeholder = "Name", onInput = {
                    onEvent(LoginEvent.OnNameChange(it))
                })

                CustomOutlinedTextField(text = state.password, placeholder = "Password", onInput = {
                    onEvent(LoginEvent.OnPasswordChange(it))
                })

                CustomFilledButton(onClick = {
                    onEvent(LoginEvent.OnSignInClick)
                }, text = "Sign In")
            }
        }
    }
}