package com.team322.prepovedia.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "review_reactions")
data class Reaction(
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val type: ReactionType? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    val review: Review? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User? = null
) : AbstractEntity()

enum class ReactionType {
    LIKE, DISLIKE
}
