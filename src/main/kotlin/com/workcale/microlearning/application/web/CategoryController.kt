package com.workcale.microlearning.application.web

import com.workcale.microlearning.domain.category.create.CreateCategoryUseCase
import com.workcale.microlearning.domain.category.delete.DeleteCategoryUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/microlearning/")
class CategoryController ( val deleteCategoryUseCase: DeleteCategoryUseCase, val createCategoryUseCase: CreateCategoryUseCase) {

    @PostMapping(path = ["/categories"])
    @Operation(summary = "Create a gategory)")
    @ApiResponses(
            ApiResponse(responseCode = "201")
    )
    fun createCategory(@RequestParam name: String): ResponseEntity<String> {
        return ResponseEntity.status(201).body(createCategoryUseCase.createCategory(name).value)
    }

    @DeleteMapping(path = ["/categories/{id}"])
    @Operation(summary = "Delete a gategory)")
    @ApiResponses(
            ApiResponse(responseCode = "204")
    )
    fun deleteCategory(@PathVariable("id") id: String): ResponseEntity<Any> {
        deleteCategoryUseCase.delete((id))
        return ResponseEntity.status(204).build()
    }
}