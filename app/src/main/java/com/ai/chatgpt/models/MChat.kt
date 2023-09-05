package com.ai.chatgpt.models

data class MChat(
    val model: String,
    val prompt: String,
    val temperature: Float,
    val max_tokens: Int,
    val top_p: Int,
    val frequency_penalty: Int,
    val presence_penalty: Int
)