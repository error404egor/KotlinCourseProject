package com.team322.prepovedia.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "reviews")
class Review(
    @Column(nullable = false, columnDefinition = "TEXT")
    val text: String,

    @Column(nullable = false)
    val rate: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    val author: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    val teacher: Teacher,

    @Column(name = "total_likes")
    val totalLikes: Int = 0,

    @Column(name = "total_dislikes")
    val totalDislikes: Int = 0
) : AbstractEntity() {

    @OneToMany(mappedBy = "review", cascade = [CascadeType.ALL])
    val reactions: List<Reaction> = mutableListOf()
}
