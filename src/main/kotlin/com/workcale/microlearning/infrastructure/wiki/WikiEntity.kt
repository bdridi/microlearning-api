package com.workcale.microlearning.infrastructure.wiki

import com.workcale.microlearning.domain.entity.Wiki

class WikiEntity(val title: String, val category: String, val url: String){

    fun toDomain(): Wiki {
        return Wiki(title, category, url)
    }
}

