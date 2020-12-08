package com.tastyeem.apichatter.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class NoLoginController {

    @RequestMapping("/hello")
    fun index(): String? {
        return "Greetings from Spring Boot!"
    }

}