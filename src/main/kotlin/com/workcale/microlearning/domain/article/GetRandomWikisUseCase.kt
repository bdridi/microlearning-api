package com.workcale.microlearning.domain.article

import com.workcale.microlearning.domain.category.CategoryRepositoryOutputPort
import com.workcale.microlearning.domain.entity.Wiki
import org.springframework.stereotype.Service

@Service
class GetRandomWikisUseCase(val wikiSearcher: WikiSearcherOutputPort,
                            val categoryRepository: CategoryRepositoryOutputPort): GetRandomWikisInputPort {

    override fun getRandomArticles(): List<Wiki> {
        var categories = categoryRepository.findAllCategories()
        return wikiSearcher.searchArticlesByCategories(categories)
    }
}