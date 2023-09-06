package com.ai.chatgpt.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.chatgpt.models.MChatDetails

@Composable
fun ChatBubble(chat: MChatDetails, isVisible: Boolean, color: Color) {

    val textColor = if (isSystemInDarkTheme()) Color.Black else Color.White

    AnimatedVisibility(visible = isVisible, enter = slideInHorizontally(animationSpec = tween(1000)), exit = slideOutHorizontally(animationSpec = tween(1000))) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = if (chat.type == "Assistant") Alignment.CenterStart else Alignment.CenterEnd
        ) {

            Surface(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)
                    .padding(20.dp),
                shape = if (chat.type == "Assistant") RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomStart = 0.dp, bottomEnd = 10.dp) else RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomStart = 10.dp, bottomEnd = 0.dp),
                color = color
            ) {
                Text(
                    text = chat.text,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    ),
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
    }
}