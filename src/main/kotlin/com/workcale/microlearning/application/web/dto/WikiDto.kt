package com.workcale.microlearning.application.web.dto

import com.workcale.microlearning.domain.entity.Wiki

data class ArticleDto(val title: String,
                      val category: String,
                      val url: String)


fun Wiki.toDto(): ArticleDto {
    return ArticleDto(
            title = title,
            category = category,
            url = url)
}