package com.workcale.microlearning.infrastructure.wiki

import com.workcale.microlearning.domain.article.WikiSearcherOutputPort
import com.workcale.microlearning.domain.entity.Wiki
import com.workcale.microlearning.domain.entity.Category
import org.springframework.stereotype.Component
import kotlin.streams.toList

@Component
class WikiSearcherAdapter(val wikiServiceClient: WikiServiceClient): WikiSearcherOutputPort {
    override fun searchArticlesByCategories(categories: List<Category>): List<Wiki> {
        return categories.stream().flatMap { c ->  wikiServiceClient.getWikis(c.value).stream()}.map { w -> w.toDomain() }.toList()
    }
}