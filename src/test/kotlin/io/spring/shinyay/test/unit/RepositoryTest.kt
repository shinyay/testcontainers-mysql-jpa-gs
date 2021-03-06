package io.spring.shinyay.test.unit

import io.spring.shinyay.test.repository.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
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

    @Test
    fun findAllBooksShouldReturnAllBooks() {
        val result = repository.findAll()

        assertAll(
            {assertThat(result[0].title).isEqualTo("GCP")},
            {assertThat(result[1].title).isEqualTo("Spring")},
            {assertThat(result[2].title).isEqualTo("Java")}
        )

//        assertThat(result[0].title).isEqualTo("Spring")
//        assertThat(result[1].title).isEqualTo("Java")
//        assertThat(result[2].title).isEqualTo("GCP")
    }
}
