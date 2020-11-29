package com.workcale.microlearning.domain.article

import com.workcale.microlearning.domain.entity.Wiki

interface GetRandomWikisInputPort {

    fun getRandomArticles(): List<Wiki>
}