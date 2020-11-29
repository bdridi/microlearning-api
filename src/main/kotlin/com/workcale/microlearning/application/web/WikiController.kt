package com.workcale.microlearning.application.web

import com.workcale.microlearning.application.web.dto.ArticleDto
import com.workcale.microlearning.application.web.dto.toDto
import com.workcale.microlearning.domain.article.GetRandomWikisUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.streams.toList

@RestController
@RequestMapping("/api/v1/microlearning/")
class WikiController {

    @Autowired
    lateinit var getRandomWikisUseCase: GetRandomWikisUseCase


    @GetMapping(path = ["/articles"])
    @Operation(summary = "Get random articles)")
    @ApiResponses(
            ApiResponse(responseCode = "200")
    )
    fun createUser(): ResponseEntity<List<ArticleDto>> {
        return ResponseEntity.ok().body(getRandomWikisUseCase.getRandomArticles().stream().map { a -> a.toDto() }.toList())
    }
}