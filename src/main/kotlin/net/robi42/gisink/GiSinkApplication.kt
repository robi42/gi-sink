package net.robi42.gisink

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

fun main(args: Array<String>) {
    SpringApplication.run(GiSinkApplication::class.java, *args)
}

@SpringBootApplication
class GiSinkApplication
