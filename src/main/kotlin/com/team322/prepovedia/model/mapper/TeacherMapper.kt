package com.team322.prepovedia.model.mapper

import com.team322.prepovedia.database.entity.Teacher
import com.team322.prepovedia.model.dto.rs.TeacherDto
import com.team322.prepovedia.model.dto.rs.LightTeacherDto
import org.springframework.stereotype.Component

@Component
class TeacherMapper(
    private val departmentMapper: DepartmentMapper,
    private val tagMapper: TagMapper
) {
    
    fun toDto(teacher: Teacher, averageRating: Double?, reviewCount: Int): TeacherDto {
        return TeacherDto(
            id = teacher.id,
            fullName = teacher.fullName,
            fullPhotoPath = teacher.fullPhotoPath,
            tags = teacher.tags.map { tagMapper.toDto(it) },
            departments = teacher.departments.map { departmentMapper.toDto(it) },
            averageRating = averageRating,
            reviewCount = reviewCount
        )
    }
    
    fun toLightDto(teacher: Teacher): LightTeacherDto {
        return LightTeacherDto(
            id = teacher.id,
            name = teacher.fullName,
            thumbnail = teacher.thumbnail,
            departments = teacher.departments.map { departmentMapper.toDto(it) }
        )
    }
}
