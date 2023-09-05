package com.ai.chatgpt.models

import androidx.compose.ui.graphics.Color

data class MChatDetails(
    val text: String,
    val color: Color,
    val type: String //types: User, Assistant
)