package com.ai.chatgpt.repositories

import com.ai.chatgpt.data.DataOrException
import com.ai.chatgpt.models.MChatRequest
import com.ai.chatgpt.models.MResponse
import com.ai.chatgpt.network.ChatApi
import javax.inject.Inject

class ChatGPTRepository @Inject constructor(
    private val chatApi: ChatApi
) {
    suspend fun getChatGptResponse(message: MChatRequest): DataOrException<MResponse?, Boolean, Exception> {
        val dataOrException = DataOrException<MResponse?, Boolean, Exception>()

        try {
            val response = chatApi.chatGptResponse(body = message)

            if (response.isSuccessful) {
                dataOrException.data = response.body()
                dataOrException.loading = false
            }
        } catch (ex: Exception) {
            dataOrException.e = ex
            dataOrException.loading = false
        }
        return dataOrException
    }
}