package com.tastyeem.apichatter.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import springfox.documentation.annotations.ApiIgnore


@Controller
@ApiIgnore
@RequestMapping("/")
class RootController {
    @RequestMapping(method = [RequestMethod.GET])
    fun swaggerUi(): String {
        return "redirect:/swagger-ui.html"
    }
}