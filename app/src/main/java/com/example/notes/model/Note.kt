package com.example.notes.model

import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
