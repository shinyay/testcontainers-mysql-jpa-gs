package com.google.shinyay.controller

import com.google.shinyay.entity.Book
import com.google.shinyay.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class BookController(val service: BookService) {

    @PostMapping("/books")
    fun registerBook(@RequestBody book: Book): ResponseEntity<Book> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.repository.save(book))
    }
}