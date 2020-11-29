package com.workcale.microlearning.domain.category.delete

import com.workcale.microlearning.domain.category.CategoryRepositoryOutputPort
import org.springframework.stereotype.Service

@Service
class DeleteCategoryUseCase(val categoryRepository: CategoryRepositoryOutputPort) : DeleteCategoryInputPort{
    override fun delete(id: String) {
        categoryRepository.deleteCategory(id)
    }
}