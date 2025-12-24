package com.team322.prepovedia.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "teachers")
class Teacher(
    @Column(name = "full_name", nullable = false)
    val fullName: String,

    val thumbnail: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    val tag: Tag? = null
) : AbstractEntity() {

    @OneToMany(mappedBy = "teacher", cascade = [CascadeType.ALL])
    val reviews: List<Review> = mutableListOf()

    @ManyToMany
    @JoinTable(
        name = "teacher_department",
        joinColumns = [JoinColumn(name = "teacher_id")],
        inverseJoinColumns = [JoinColumn(name = "department_id")]
    )
    val departments: List<Department> = mutableListOf()
}