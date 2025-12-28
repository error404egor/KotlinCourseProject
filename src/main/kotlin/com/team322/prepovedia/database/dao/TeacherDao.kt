package com.team322.prepovedia.database.dao

import com.team322.prepovedia.database.entity.Teacher
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TeacherDao: AbstractDao<Teacher> {
    
    @Query("SELECT t FROM Teacher t JOIN t.departments d WHERE d.university.id = :universityId")
    fun findByUniversityId(@Param("universityId") universityId: Long): List<Teacher>
    
    @Query("SELECT t FROM Teacher t JOIN t.departments d WHERE d.id = :departmentId")
    fun findByDepartmentId(@Param("departmentId") departmentId: Long): List<Teacher>
}