package com.ai.chatgpt.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import com.ai.chatgpt.components.AppBar
import com.ai.chatgpt.components.BottomBar
import com.ai.chatgpt.components.ChatBubble
import com.ai.chatgpt.models.MChatDetails
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {

    val questionState = remember { mutableStateOf("") }
    val questionCard = remember { mutableStateOf("") }
    val response = viewModel.response.collectAsState().value.data?.choices

    //Toast Exception
    val context = LocalContext.current
    val exception = viewModel.response.collectAsState().value.e?.localizedMessage
//    LaunchedEffect(key1 = exception) { Toast.makeText(context, exception, Toast.LENGTH_LONG).show() }
    if (exception?.isNotBlank() == true) Toast.makeText(context, exception, Toast.LENGTH_LONG).show()

    val localKeyboard = LocalSoftwareKeyboardController.current

    val chatList = remember { mutableListOf<MChatDetails>() }

    //Dummy List
    val list = remember {
        mutableListOf<MChatDetails>(
            MChatDetails("Say this is a test", Color.Blue, "User"),
            MChatDetails("Say this is a test", Color.Green, "Assistant"),
            MChatDetails("Say this is a test", Color.Blue, "User"),
            MChatDetails("Say this is a test", Color.Green, "Assistant"),
            MChatDetails("Say this is a test", Color.Blue, "User"),
            MChatDetails("Say this is a test", Color.Green, "Assistant"),
            MChatDetails("Say this is a test", Color.Blue, "User"),
            MChatDetails("Say this is a test", Color.Green, "Assistant"),
            MChatDetails("Say this is a test", Color.Blue, "User"),
            MChatDetails("Say this is a test", Color.Green, "Assistant"),
            MChatDetails("Say this is a test", Color.Blue, "User"),
            MChatDetails("Say this is a test", Color.Green, "Assistant")
        )
    }

    //Update response in list
    if (response?.isNotEmpty() == true) {
        LaunchedEffect(key1 = response) {
            chatList.add(MChatDetails(text = response[0].text.trim(), color = Color(0xFF8FBE8F), type = "Assistant"))
        }
    }

    val scrollState = rememberScrollState()
    //Scroll down on new response
    LaunchedEffect(key1 = response) {
        delay(600)
        if (scrollState.canScrollForward) scrollState.animateScrollTo(scrollState.maxValue)
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBar(text = questionState) {
        questionCard.value = questionState.value
        if (questionState.value != "") {
            viewModel.getChatGPTResponse(question = questionState.value.trim())
            chatList.add(MChatDetails(text = questionState.value.trim(), color = Color(0xFF62A7DF), type = "User"))
            questionState.value = ""
            localKeyboard?.hide()
        }
    }
        },
        topBar = { AppBar() }
    ) { innerPadding ->

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start) {

            for (chat in chatList) {
                ChatBubble(chat = chat, isVisible = true, color = chat.color)
            }

//            LazyColumn(state = scrollState) {
//
//                items(items = chatList) { chat ->
//                    ChatBubble(chat = chat, isVisible = true, color = chat.color)
//                }
//            }
        }
    }
}

