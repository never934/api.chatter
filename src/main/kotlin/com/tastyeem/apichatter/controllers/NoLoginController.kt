package com.tastyeem.apichatter.controllers

import com.tastyeem.apichatter.models.AuthRequest
import com.tastyeem.apichatter.models.TokenView
import com.tastyeem.apichatter.models.UserRequest
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.annotations.ApiIgnore


@RestController()
@RequestMapping("/v1/nologin")
@Api(value = "Auth", description = "app login/register")
class NoLoginController {

    @RequestMapping(method = [RequestMethod.POST], value = ["/auth"])
    @ApiOperation(value = "authentication of user")
    fun auth(@RequestBody authRequest: AuthRequest): TokenView {
        return TokenView("token")
    }

    @RequestMapping(method = [RequestMethod.POST], value = ["/register"])
    @ApiOperation(value = "registration of new user")
    fun register(@RequestBody userRequest: UserRequest): TokenView {
        return TokenView("token")
    }

}