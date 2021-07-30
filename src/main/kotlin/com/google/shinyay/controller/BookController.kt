package com.google.shinyay.controller

import com.google.shinyay.service.BookService
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(val service: BookService) {
}