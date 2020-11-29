package com.workcale.microlearning.infrastructure.db

import com.workcale.microlearning.domain.entity.Category
import junit.framework.Assert.*
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [RedisTestConfiguration::class])
class CategoryRepositoryTest {

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    @Test
    fun  `create a category`() {
        categoryRepository.createCategory(Category("sport"))
        var category = categoryRepository.findById("sport")
        assertNotNull(category)
    }

    @Test
    fun  `delete a category`() {
        categoryRepository.createCategory(Category("sport"))
        var category = categoryRepository.findById("sport")
        assertNotNull(category)
        categoryRepository.deleteCategory("sport")
        category = categoryRepository.findById("sport")
        assertNull(category)
        var categories = categoryRepository.findAllCategories()
        print(categories)
        categoryRepository.deleteCategory("sport")
        categories = categoryRepository.findAllCategories()
        print(categories)
    }

    @Test
    fun  `find all categories`() {
        categoryRepository.createCategory(Category("sport"))
        categoryRepository.createCategory(Category("health"))
        categoryRepository.createCategory(Category("science"))
        var categories = categoryRepository.findAllCategories()
        assertNotNull(categories)
        assertEquals(3, categories.size)
    }
}