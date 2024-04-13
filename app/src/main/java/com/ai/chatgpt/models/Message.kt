package com.ai.chatgpt.models

import androidx.compose.runtime.Stable

@Stable
data class Message(
    val content: String,
    val role: String
)