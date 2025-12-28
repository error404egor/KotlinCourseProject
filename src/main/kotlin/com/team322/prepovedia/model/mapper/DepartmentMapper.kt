package com.team322.prepovedia.model.mapper

import com.team322.prepovedia.database.entity.Department
import com.team322.prepovedia.model.dto.rs.DepartmentDto
import org.springframework.stereotype.Component

@Component
class DepartmentMapper {
    
    fun toDto(department: Department): DepartmentDto {
        return DepartmentDto(
            id = department.id,
            name = department.name,
            universityName = department.university.name
        )
    }
}
