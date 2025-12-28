package com.team322.prepovedia.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val university: String
) : AbstractEntity() {

    @OneToMany(mappedBy = "author", cascade = [CascadeType.ALL])
    val reviews: List<Review> = mutableListOf()

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
    val reactions: List<Reaction> = mutableListOf()
}
