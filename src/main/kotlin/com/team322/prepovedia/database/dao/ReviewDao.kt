package com.team322.prepovedia.database.dao

import com.team322.prepovedia.database.entity.Review
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ReviewDao: AbstractDao<Review> {
    
    fun findByTeacherId(teacherId: Long): List<Review>
    
    @Query("SELECT AVG(r.rate) FROM Review r WHERE r.teacher.id = :teacherId")
    fun findAverageRatingByTeacherId(@Param("teacherId") teacherId: Long): Double?
    
    @Query("SELECT COUNT(r) FROM Review r WHERE r.teacher.id = :teacherId")
    fun countByTeacherId(@Param("teacherId") teacherId: Long): Long
}