package com.team322.prepovedia.model.dto.rs

class CommentDto(
    val id: Long,
    val text: String,
    val authorName: String,
    val createdAt: java.time.LocalDateTime
)