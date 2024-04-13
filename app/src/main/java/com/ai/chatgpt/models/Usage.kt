package com.ai.chatgpt.models

import androidx.compose.runtime.Stable

@Stable
data class Usage(
    val completion_tokens: Int,
    val prompt_tokens: Int,
    val total_tokens: Int
)