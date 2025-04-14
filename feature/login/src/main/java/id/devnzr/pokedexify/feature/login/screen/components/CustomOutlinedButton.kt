package id.devnzr.pokedexify.feature.login.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.devnzr.pokedexify.feature.login.R

@Composable
fun CustomOutlinedButton(onClick: () -> Unit, text: String) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        border = BorderStroke(3.dp, Color.Black)
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(id.devnzr.pokedexify.core.uikit.R.font.roboto_regular))
            )
        )
    }
}