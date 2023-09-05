package com.ai.chatgpt.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.chatgpt.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(text: MutableState<String>, onClick: () -> Unit) {
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(start = 20.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            TextField(value = text.value, onValueChange = { text.value = it }, singleLine = false,
                modifier = Modifier.fillMaxWidth(0.88f),
                colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent),
                shape = RoundedCornerShape(10.dp),
                placeholder = { Text(text = "Who is Prasidh Gopal Anchan?", style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Normal, color = Color.Black.copy(alpha = 0.8f))) }
            )

            IconButton(onClick = { onClick.invoke() }) {
                Icon(painter = painterResource(id = R.drawable.send), contentDescription = "Send",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(40.dp))
            }
        }
//    }
}