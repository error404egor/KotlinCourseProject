package com.team322.prepovedia.model.dto.rs

import java.time.LocalDateTime

class ReviewDto(
    val id: Long,
    val text: String,
    val rate: Int,
    val author: UserDto,
    val teacher: TeacherDto,
    val totalLikes: Int,
    val totalDislikes: Int,
    val createdAt: LocalDateTime
)
