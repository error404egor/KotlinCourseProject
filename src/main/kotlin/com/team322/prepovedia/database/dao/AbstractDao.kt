package com.team322.prepovedia.database.dao


import com.team322.prepovedia.database.entity.AbstractEntity
import org.springframework.data.repository.CrudRepository

interface AbstractDao<T: AbstractEntity>: CrudRepository<T, Long>