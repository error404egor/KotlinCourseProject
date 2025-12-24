package com.team322.prepovedia.database.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@MappedSuperclass
abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
}