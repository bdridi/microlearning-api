package com.workcale.microlearning.infrastructure.wiki

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam


@FeignClient(name = "wiki", url = "\${service.wiki.url}")
interface WikiServiceClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/api/v1/wiki"], produces = ["application/json"])
    fun getWikis(@RequestParam("category") category: String?): List<WikiEntity>
}