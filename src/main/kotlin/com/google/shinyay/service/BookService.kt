package com.google.shinyay.service

import com.google.shinyay.entity.Book
import com.google.shinyay.logger
import com.google.shinyay.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun findBookByIsbn(isbn: String): MutableList<Book> {
        logger.info("[ISBN]: $isbn")
        return repository.findBookByIsbn(isbn)
    }
}