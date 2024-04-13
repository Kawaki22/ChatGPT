package com.ai.chatgpt.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ai.chatgpt.data.DataOrException
import com.ai.chatgpt.models.MChatRequest
import com.ai.chatgpt.models.MResponse
import com.ai.chatgpt.repositories.ChatGPTRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val chatGPTRepository: ChatGPTRepository
) : ViewModel() {

    private var _response: MutableStateFlow<DataOrException<MResponse?, Boolean, Exception>> =
        MutableStateFlow(DataOrException(null, false, Exception("")))
    val response = _response

    fun getChatGPTResponse(question: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val mChatRequest = MChatRequest(
                model = "text-davinci-003",
                prompt = question,
                max_tokens = 256,
                temperature = 0f,
                top_p = 1,
                frequency_penalty = 0,
                presence_penalty = 0,
            )

            _response.update { it.copy(loading = true) }
            _response.value = chatGPTRepository.getChatGptResponse(message = mChatRequest)
            if (_response.value.data != null) _response.update { it.copy(loading = false) }
        }
    }
}