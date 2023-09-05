package com.ai.chatgpt.repositories

import com.ai.chatgpt.models.MChat
import com.ai.chatgpt.models.MResponse
import com.ai.chatgpt.models.Usage
import com.ai.chatgpt.network.ChatApi
import javax.inject.Inject

class ChatGPTRepository @Inject constructor(private val chatApi: ChatApi) {

    suspend fun getChatGptResponse(message: MChat): MResponse {
        var response = MResponse(listOf(), 0, "", "", "", Usage(0, 0, 0))
        try {
            response = chatApi.chatGptResponse(body = message)
        } catch (ex: Exception) {
            //TODO handle exception
        }
        return response
    }
}