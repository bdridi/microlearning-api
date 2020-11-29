package com.workcale.microlearning.infrastructure.db.model

import com.workcale.microlearning.domain.entity.Category
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("Category")

data class CategoryEntity(val id: String, val value: String){

    fun toDomain(): Category{
        return Category(value = value)
    }
}

