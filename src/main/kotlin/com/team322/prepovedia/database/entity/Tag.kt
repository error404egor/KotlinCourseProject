package com.team322.prepovedia.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "tags")
data class Tag(
    @Column(nullable = false)
    val name: String = ""
) : AbstractEntity() {

    @ManyToMany(mappedBy = "tags")
    val teachers: List<Teacher> = mutableListOf()
}
