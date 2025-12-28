package com.team322.prepovedia.service

import com.team322.prepovedia.model.dto.rs.LightTeacherDto
import com.team322.prepovedia.model.dto.rs.ReviewDto
import com.team322.prepovedia.model.dto.rs.TeacherDto

interface TeacherService {
    fun getAllTeachers(): List<LightTeacherDto>
    fun getTeacherById(id: Long): TeacherDto?
    fun getTeacherReviews(teacherId: Long): List<ReviewDto>
}
