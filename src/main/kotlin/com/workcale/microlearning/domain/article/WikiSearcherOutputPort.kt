package com.workcale.microlearning.domain.article

import com.workcale.microlearning.domain.entity.Wiki
import com.workcale.microlearning.domain.entity.Category

interface WikiSearcherOutputPort {
    fun searchArticlesByCategories(categories: List<Category>): List<Wiki>
}
