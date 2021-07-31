package com.google.shinyay.testmysql

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.shinyay.entity.Book
import com.google.shinyay.repository.BookRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class TestContainerForBook {

    @Autowired
    lateinit var repository: BookRepository

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    companion object {
        @Container
        val database = MySQLContainer<Nothing>("mysql:5.7.33").apply {
            withDatabaseName("myapp")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", database::getJdbcUrl)
            registry.add("spring.datasource.username", database::getUsername)
            registry.add("spring.datasource.password", database::getPassword)
            registry.add("spring.jpa.hibernate.ddl-auto") { "create-drop" }
        }
    }

    @Test
    fun shouldCreateBook() {
        val json = objectMapper.writeValueAsString(
            Book(id = 0, isbn = "978-4-7710-1067-3",title = "test", author = "shinyay", price = 100)
        )
        mockMvc.perform(post("/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isCreated)
    }
}