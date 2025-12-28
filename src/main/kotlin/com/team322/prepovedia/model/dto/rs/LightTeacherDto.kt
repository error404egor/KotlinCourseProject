package com.team322.prepovedia.model.dto.rs

data class LightTeacherDto (
    val id: Long,
    val name: String,
    val thumbnail: String?,
    val departments: List<DepartmentDto>,
)