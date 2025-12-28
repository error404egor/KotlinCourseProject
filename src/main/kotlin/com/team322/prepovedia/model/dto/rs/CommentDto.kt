package com.team322.prepovedia.model.dto.rs

class CommentDto(
    val id: Long,
    val text: String,
    val author: UserDto,
    val createdAt: java.time.LocalDateTime
)