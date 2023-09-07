package com.ai.chatgpt.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.chatgpt.Utils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultScreen(cardValue: (String) -> Unit, bottomBar: @Composable () -> Unit) {

    val openUri = LocalUriHandler.current

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { AppBar() },
        bottomBar = { bottomBar.invoke() }) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally) {

            TextCard(text = "GitHub", subText = "developer info") { openUri.openUri("https://www.github.com/Kawaki22") }
            TextCard(text = "Create a workout plan", subText = "for resistance training") { cardValue("Create a workout plan for resistance training") }

        }
    }
}

@Composable
fun TextCard(text: String, subText: String, onClick: () -> Unit = {  }) {
    val fontColorLight = if (isSystemInDarkTheme()) Color.White.copy(alpha = 0.6f) else Color.Black.copy(alpha = 0.6f)
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(start = 20.dp, end = 20.dp, bottom = 20.dp,)
        .clip(RoundedCornerShape(10.dp))
        .clickable { onClick.invoke() },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 2.dp, color = Utils.gptGreen.copy(alpha = 0.8f))
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start) {
            Text(text = text, style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start))
            Text(text = subText, style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal, color = fontColorLight, textAlign = TextAlign.Start))
        }
    }
}

//@Preview
//@Composable
//fun Prev() {
//    DefaultScreen() {  }
//}