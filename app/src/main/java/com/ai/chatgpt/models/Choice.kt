package com.ai.chatgpt.models

import androidx.compose.runtime.Stable

@Stable
data class Choice(
    val finish_reason: String,
    val index: Int,
    val logprobs: Any,
    val text: String
)