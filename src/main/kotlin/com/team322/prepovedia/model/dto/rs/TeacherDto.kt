package com.team322.prepovedia.model.dto.rs

data class TeacherDto(
    val id: Long,
    val fullName: String,
    val fullPhotoPath: String?,
    val tags: List<TagDto>,
    val departments: List<DepartmentDto>,
    val averageRating: Double?,
    val reviewCount: Int
)