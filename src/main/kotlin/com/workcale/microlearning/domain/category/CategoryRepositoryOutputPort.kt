package com.workcale.microlearning.domain.category

import com.workcale.microlearning.domain.entity.Category
import org.springframework.stereotype.Component

interface CategoryRepositoryOutputPort {
    fun findAllCategories(): List<Category>
    fun findById(id: String): Category?
    fun createCategory(category: Category): Category
    fun deleteCategory(id: String)
    fun deleteAll()

}
