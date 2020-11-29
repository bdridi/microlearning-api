package com.workcale.microlearning.domain.category.create

import com.workcale.microlearning.domain.category.CategoryRepositoryOutputPort
import com.workcale.microlearning.domain.entity.Category
import org.springframework.stereotype.Service

@Service
class CreateCategoryUseCase(val categoryRepository: CategoryRepositoryOutputPort) : CreateCategoryInputPort{
    override fun createCategory(name: String): Category {
        return categoryRepository.createCategory(Category(name))
    }
}