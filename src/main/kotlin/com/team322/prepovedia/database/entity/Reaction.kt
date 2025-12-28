package com.team322.prepovedia.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "review_reactions")
class Reaction(
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val type: ReactionType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    val review: Review,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User
) : AbstractEntity()

enum class ReactionType {
    LIKE, DISLIKE
}
