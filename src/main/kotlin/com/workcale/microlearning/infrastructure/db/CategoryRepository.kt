package com.workcale.microlearning.infrastructure.db

import com.workcale.microlearning.domain.category.CategoryRepositoryOutputPort
import com.workcale.microlearning.domain.entity.Category
import com.workcale.microlearning.infrastructure.db.model.CategoryEntity
import org.springframework.stereotype.Component

@Component
class CategoryRepository(val redisCategoryRepository: RedisCategoryRepository) : CategoryRepositoryOutputPort {

    override fun findAllCategories(): List<Category> {
        return redisCategoryRepository.findAll().map { ce -> ce.toDomain() }
    }

    override fun createCategory(category: Category): Category {
        // the category value is used as id
        return redisCategoryRepository.save(CategoryEntity(category.value, category.value))
                .toDomain()
    }

    override fun deleteCategory(id: String) {
        redisCategoryRepository.deleteById(id)
    }

    override fun deleteAll() {
        redisCategoryRepository.deleteAll()
    }

    override fun findById(id: String): Category? {
        val optionalCategory = redisCategoryRepository.findById(id)
        if(optionalCategory.isPresent)
            return optionalCategory.get().toDomain()
        return null
    }
}