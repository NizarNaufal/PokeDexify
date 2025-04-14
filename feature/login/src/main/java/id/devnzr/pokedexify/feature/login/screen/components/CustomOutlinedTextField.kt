package id.devnzr.pokedexify.feature.login.screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(text: String, placeholder: String, onInput: (String) -> Unit) {

    OutlinedTextField(
        value = text,
        onValueChange = {
            onInput(it)
        },
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(id.devnzr.pokedexify.core.uikit.R.font.roboto_regular))
        ),
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(id.devnzr.pokedexify.core.uikit.R.font.roboto_regular))
                )
            )
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        maxLines = 1,
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Gray,
            focusedTextColor = Color.Black
        )
    )

}