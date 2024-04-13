package com.ai.chatgpt.models

import androidx.compose.runtime.Stable

@Stable
data class MResponse(
    val choices: List<Choice>,
    val created: Int,
    val id: String,
    val model: String,
    val `object`: String,
    val usage: Usage
)