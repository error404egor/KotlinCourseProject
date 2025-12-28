package com.team322.prepovedia.model.dto.rs

import java.time.LocalDateTime

data class ReviewDto(
    val id: Long,
    val text: String,
    val rate: Int,
    val authorName: String,
    val teacherName: String,
    val totalLikes: Int,
    val totalDislikes: Int,
    val createdAt: LocalDateTime
)
