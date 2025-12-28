package com.team322.prepovedia.model.dto.rs

import com.team322.prepovedia.database.entity.ReactionType

class ReactionDto(
    val id: Long,
    val type: ReactionType,
    val userName: String
)