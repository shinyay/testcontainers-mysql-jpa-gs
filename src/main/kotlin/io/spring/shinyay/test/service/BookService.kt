package io.spring.shinyay.test.service

import io.spring.shinyay.test.entity.Book
import io.spring.shinyay.test.logger
import io.spring.shinyay.test.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun findBookByIsbn(isbn: String): MutableList<Book> {
        logger.info("[ISBN]: $isbn")
        return repository.findBookByIsbn(isbn)
    }
}
