package com.ai.chatgpt.repositories

import com.ai.chatgpt.data.DataOrException
import com.ai.chatgpt.models.MChat
import com.ai.chatgpt.models.MResponse
import com.ai.chatgpt.network.ChatApi
import javax.inject.Inject

class ChatGPTRepository @Inject constructor(private val chatApi: ChatApi) {

    suspend fun getChatGptResponse(message: MChat): DataOrException<MResponse?, Boolean, Exception> {
//        var response = DataOrException<MResponse(listOf(), 0, "", "", "", Usage(0, 0, 0))>
        val response = DataOrException<MResponse?, Boolean, Exception>()
        try {
            response.data = chatApi.chatGptResponse(body = message)
        } catch (ex: Exception) {
            response.e = ex
            //TODO handle exception
        }
        return response
    }
}