package com.team322.prepovedia.model.mapper

import com.team322.prepovedia.database.entity.Tag
import com.team322.prepovedia.model.dto.rs.TagDto
import org.springframework.stereotype.Component

@Component
class TagMapper {
    
    fun toDto(tag: Tag): TagDto {
        return TagDto(
            id = tag.id,
            name = tag.name
        )
    }
}