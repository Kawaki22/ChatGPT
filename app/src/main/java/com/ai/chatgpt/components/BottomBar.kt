package com.ai.chatgpt.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.chatgpt.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(text: MutableState<String>, onClick: () -> Unit) {
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
    val textColor = if (isSystemInDarkTheme()) Color.White.copy(alpha = 0.8f) else Color.Black.copy(alpha = 0.8f)

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 20.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            TextField(value = text.value, onValueChange = { text.value = it }, singleLine = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                placeholder = { Text(text = "Who is Prasidh Gopal Anchan?", modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 4.dp), style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Normal, color = textColor), textAlign = TextAlign.Center) },
                trailingIcon = {
                    IconButton(onClick = { onClick.invoke() }) {
                        Icon(painter = painterResource(id = R.drawable.send), contentDescription = "Send",
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .size(25.dp))
                    } },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
            )
        }
        Text(text = "ChatGPT version 3.5", style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal), modifier = Modifier.padding(20.dp))
    }
}