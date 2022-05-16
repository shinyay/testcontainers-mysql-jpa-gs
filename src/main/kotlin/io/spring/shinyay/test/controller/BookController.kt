package io.spring.shinyay.test.controller

import io.spring.shinyay.test.entity.Book
import io.spring.shinyay.test.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class BookController(val service: BookService) {

    @GetMapping("/books")
    fun findAllBooks(): ResponseEntity<MutableList<Book>> {
        return ResponseEntity.status(HttpStatus.OK).body(service.repository.findAll())
    }

    @GetMapping("/books/{isbn}")
    fun findBookByIsbn(@PathVariable isbn: String): ResponseEntity<List<Book>> {
        return ResponseEntity.status(HttpStatus.OK).body(service.findBookByIsbn(isbn))
    }

    @PostMapping("/books")
    fun registerBook(@RequestBody book: Book): ResponseEntity<Book> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.repository.save(book))
    }
}
