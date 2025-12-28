package com.team322.prepovedia.contoller

import com.team322.prepovedia.model.dto.rs.LightTeacherDto
import com.team322.prepovedia.model.dto.rs.ReviewDto
import com.team322.prepovedia.service.TeacherService
import com.team322.prepovedia.model.dto.rs.TeacherDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/teachers")
class TeacherController(private val teacherService: TeacherService) {

    @GetMapping
    fun getAllTeachers(): List<LightTeacherDto> = teacherService.getAllTeachers()

    @GetMapping("/{id}")
    fun getTeacherById(@PathVariable id: Long): TeacherDto? = teacherService.getTeacherById(id)

    @GetMapping("/{id}/reviews")
    fun getTeacherReviews(@PathVariable id: Long): List<ReviewDto> =
        teacherService.getTeacherReviews(id)
}