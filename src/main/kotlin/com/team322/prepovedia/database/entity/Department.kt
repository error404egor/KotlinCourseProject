package com.team322.prepovedia.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "departments")
class Department(
    @Column(nullable = false)
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    val university: University
) : AbstractEntity() {

    @ManyToMany(mappedBy = "departments")
    val teachers: List<Teacher> = mutableListOf()
}