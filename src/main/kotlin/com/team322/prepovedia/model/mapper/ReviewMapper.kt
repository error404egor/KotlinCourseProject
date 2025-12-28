package com.team322.prepovedia.model.mapper

import com.team322.prepovedia.database.entity.Review
import com.team322.prepovedia.model.dto.rs.ReviewDto
import org.springframework.stereotype.Component

@Component
class ReviewMapper {
    
    fun toDto(review: Review): ReviewDto {
        return ReviewDto(
            id = review.id!!,
            text = review.text,
            rate = review.rate,
            authorName = review.author?.name ?: "",
            teacherName = review.teacher?.fullName ?: "",
            totalLikes = review.totalLikes,
            totalDislikes = review.totalDislikes,
            createdAt = review.createdAt
        )
    }
}
