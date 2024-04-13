package com.ai.chatgpt.models

import androidx.compose.runtime.Stable

@Stable
data class MChatRequest(
    val model: String,
    val prompt: String,
    val temperature: Float,
    val max_tokens: Int,
    val top_p: Int,
    val frequency_penalty: Int,
    val presence_penalty: Int
)