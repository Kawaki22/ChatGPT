package com.ai.chatgpt.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.chatgpt.R

@Composable
fun AppBar() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)) {
        Row(modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.chatgpt), contentDescription = "ChatGPT", modifier = Modifier.size(45.dp).padding(end = 10.dp))
            Text(text = "ChatGPT", style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold))
        }
    }
}