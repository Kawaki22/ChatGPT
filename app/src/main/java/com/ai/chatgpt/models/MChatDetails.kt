package com.ai.chatgpt.models

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

@Stable
data class MChatDetails(
    val text: String,
    val color: Color,
    val type: String //types: User, Assistant
)