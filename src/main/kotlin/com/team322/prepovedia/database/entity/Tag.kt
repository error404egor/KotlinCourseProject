package com.team322.prepovedia.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "tags")
class Tag(
    @Column(nullable = false)
    val name: String
) : AbstractEntity() {

    @OneToMany(mappedBy = "tag")
    val teachers: List<Teacher> = mutableListOf()
}