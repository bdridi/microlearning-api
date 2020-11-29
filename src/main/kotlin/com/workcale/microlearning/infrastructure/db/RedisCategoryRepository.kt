package com.workcale.microlearning.infrastructure.db

import com.workcale.microlearning.infrastructure.db.model.CategoryEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RedisCategoryRepository: CrudRepository<CategoryEntity, String>