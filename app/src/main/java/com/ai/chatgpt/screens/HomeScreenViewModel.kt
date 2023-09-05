package com.ai.chatgpt.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.chatgpt.models.Choice
import com.ai.chatgpt.models.MChat
import com.ai.chatgpt.repositories.ChatGPTRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val chatGPTRepository: ChatGPTRepository): ViewModel() {

    private var _response: MutableStateFlow<List<Choice>>? = MutableStateFlow(emptyList<Choice>())
    val response = _response

    fun getChatGPTResponse(question: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val mChat = MChat(
                model = "text-davinci-003",
                prompt = question,
                max_tokens = 256,
                temperature = 0f,
                top_p = 1,
                frequency_penalty = 0,
                presence_penalty = 0,
            )
            _response?.value = chatGPTRepository.getChatGptResponse(message = mChat).choices
//            Log.d("RESPONSEE", "Choices: ${response.value}")
        }
    }
}