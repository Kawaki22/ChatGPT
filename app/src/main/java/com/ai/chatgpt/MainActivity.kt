package com.ai.chatgpt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.ai.chatgpt.navigation.Navigation
import com.ai.chatgpt.screens.HomeScreen
import com.ai.chatgpt.ui.theme.ChatGPTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatGPTTheme {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                MyChatGPTApp()
            }
        }
    }
}

@Composable
fun MyChatGPTApp() {
    Navigation()
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ChatGPTTheme {
//    }
//}