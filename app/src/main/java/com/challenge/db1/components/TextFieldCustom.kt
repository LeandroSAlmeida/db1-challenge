package com.challenge.db1.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.challenge.db1.R
import com.challenge.db1.ui.theme.ColorPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldCustom(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    KeyboardOptions: KeyboardOptions = KeyboardOptions(),
    icon: Int = R.drawable.id_username,
    iconContentDescription: String? = null
){

    TextField(
        value,
        onValueChange,
        modifier,
        label = {
            Text(text = hint, color = Color.White)
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = ColorPrimary,
            cursorColor = Color.White
        ),
        maxLines = 1,
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 18.sp
        ),
        keyboardOptions = KeyboardOptions,
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = iconContentDescription,
                tint = Color.White
            )
        }


    )

}

@Composable
@Preview
private fun TextFieldCustomPreview(){

    var username by remember {
        mutableStateOf("")
    }

    TextFieldCustom(
        value = username,
        onValueChange = {
            username = it
        },
        hint = "Username",
        icon = R.drawable.id_username,
        iconContentDescription = "Icon User"
    )
}