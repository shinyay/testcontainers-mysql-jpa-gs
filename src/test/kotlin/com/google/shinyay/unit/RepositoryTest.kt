package com.google.shinyay.unit

import com.google.shinyay.repository.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RepositoryTest {

    @Autowired
    lateinit var repository: BookRepository

    @Test
    fun findAllBooksShouldReturnCount() {
        val result = repository.findAll()

        assertThat(result.count()).isEqualTo(3)
    }
}