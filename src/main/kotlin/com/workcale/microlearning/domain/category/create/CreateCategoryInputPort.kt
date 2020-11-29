package com.workcale.microlearning.domain.category.create

import com.workcale.microlearning.domain.entity.Category

interface CreateCategoryInputPort {

    fun createCategory(name: String): Category
}