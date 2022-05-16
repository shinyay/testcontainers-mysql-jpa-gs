package io.sprint.shinyay.test.service

import io.sprint.shinyay.test.entity.Book
import io.sprint.shinyay.test.logger
import io.sprint.shinyay.test.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun findBookByIsbn(isbn: String): MutableList<Book> {
        logger.info("[ISBN]: $isbn")
        return repository.findBookByIsbn(isbn)
    }
}
