package com.team322.prepovedia.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "departments")
data class Department(
    @Column(nullable = false)
    val name: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    val university: University? = null
) : AbstractEntity() {

    @ManyToMany(mappedBy = "departments")
    val teachers: List<Teacher> = mutableListOf()
}
