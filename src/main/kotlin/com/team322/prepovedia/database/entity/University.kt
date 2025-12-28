package com.team322.prepovedia.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "universities")
class University(
    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val city: String,

    val thumbnail: String? = null,

    val university: String? = null
) : AbstractEntity() {

    @OneToMany(mappedBy = "university", cascade = [CascadeType.ALL])
    val departments: List<Department> = mutableListOf()
}
