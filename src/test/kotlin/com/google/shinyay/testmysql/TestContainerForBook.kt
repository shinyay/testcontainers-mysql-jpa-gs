package com.google.shinyay.testmysql

import com.google.shinyay.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class TestContainerForBook {

    @Container
    val database = MySQLContainer<Nothing>("mysql:5.7.33")

    @Autowired
    lateinit var repository: BookRepository
}