package com.team322.prepovedia.service.impl

import com.team322.prepovedia.database.dao.TeacherDao
import com.team322.prepovedia.database.dao.ReviewDao
import com.team322.prepovedia.model.dto.rs.LightTeacherDto
import com.team322.prepovedia.model.dto.rs.ReviewDto
import com.team322.prepovedia.model.dto.rs.TeacherDto
import com.team322.prepovedia.model.mapper.TeacherMapper
import com.team322.prepovedia.model.mapper.ReviewMapper
import com.team322.prepovedia.service.TeacherService
import org.springframework.stereotype.Service

@Service
class TeacherServiceImpl(
    private val teacherDao: TeacherDao,
    private val reviewDao: ReviewDao,
    private val teacherMapper: TeacherMapper,
    private val reviewMapper: ReviewMapper
) : TeacherService {

    override fun getAllTeachers(): List<LightTeacherDto> {
        return teacherDao.findAll().map { teacherMapper.toLightDto(it) }
    }

    override fun getTeacherById(id: Long): TeacherDto? {
        return teacherDao.findById(id).map { teacher ->
            val averageRating = reviewDao.findAverageRatingByTeacherId(id)
            val reviewCount = reviewDao.countByTeacherId(id).toInt()
            teacherMapper.toDto(teacher, averageRating, reviewCount)
        }.orElse(null)
    }

    override fun getTeacherReviews(teacherId: Long): List<ReviewDto> {
        return reviewDao.findByTeacherId(teacherId).map { reviewMapper.toDto(it) }
    }
}
