package com.team322.prepovedia.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "teachers")
class Teacher(
    @Column(name = "full_name", nullable = false)
    val fullName: String,

    val thumbnail: String? = null,

    @Column(name = "full_photo_path")
    val fullPhotoPath: String? = null,

    @ManyToMany
    @JoinTable(
        name = "teacher_tag",
        joinColumns = [JoinColumn(name = "teacher_id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id")]
    )
    val tags: List<Tag> = mutableListOf()
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
