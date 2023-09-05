package com.ai.chatgpt.network

import com.ai.chatgpt.Utils
import com.ai.chatgpt.models.MChat
import com.ai.chatgpt.models.MResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface ChatApi {

    @Headers("Content-Type: ${Utils.CONTENT_TYPE}", "Authorization: Bearer ${Utils.API_KEY}")
    @POST("v1/completions")
    suspend fun chatGptResponse(@Body body: MChat): MResponse

}