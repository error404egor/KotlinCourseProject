package com.team322.prepovedia.model.dto.rs

class TeacherDto(
    val id: Long,
    val fullName: String,
    val thumbnail: String?,
    val tags: List<TagDto>,
    val departments: List<DepartmentDto>
)