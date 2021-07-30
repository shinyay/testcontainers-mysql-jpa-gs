package com.google.shinyay.testmysql

import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
class TestContainerForBook {

    @Container
    val database = MySQLContainer<Nothing>("mysql:5.7.33")
}