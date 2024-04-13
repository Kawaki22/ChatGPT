package com.ai.chatgpt.network

import com.ai.chatgpt.Utils.API_KEY
import com.ai.chatgpt.Utils.CONTENT_TYPE
import com.ai.chatgpt.models.MChatRequest
import com.ai.chatgpt.models.MResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface ChatApi {

    @Headers("Content-Type: $CONTENT_TYPE", "Authorization: Bearer $API_KEY")
    @POST("v1/completions")
    suspend fun chatGptResponse(@Body body: MChatRequest): Response<MResponse>

}