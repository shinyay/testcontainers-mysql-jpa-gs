package io.sprint.shinyay.test.repository

import io.sprint.shinyay.test.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {

    fun findBookByIsbn(isbn: String): MutableList<Book>
}
