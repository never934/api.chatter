package com.tastyeem.apichatter.controllers


import com.tastyeem.apichatter.AppConst
import com.tastyeem.apichatter.Application
import com.tastyeem.apichatter.models.db.User
import com.tastyeem.apichatter.models.request.AuthRequest
import com.tastyeem.apichatter.models.request.UserRequest
import com.tastyeem.apichatter.models.view.ErrorView
import com.tastyeem.apichatter.models.view.TokenView
import com.tastyeem.apichatter.repository.UserRepository
import com.tastyeem.apichatter.utils.TokenUtils
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController()
@RequestMapping("/v1/nologin")
@Api(value = "Auth", description = "app login/register")
class NoLoginController(val userRepository: UserRepository) {

    @RequestMapping(method = [RequestMethod.POST], value = ["/auth"])
    @ApiOperation(value = "authentication of user")
    fun auth(@RequestBody authRequest: AuthRequest): ResponseEntity<TokenView> {
        return ResponseEntity.ok().body(TokenView(TokenUtils().getJWTToken(authRequest.login) ?: ""))
    }

    @RequestMapping(method = [RequestMethod.POST], value = ["/register"])
    @ApiOperation(value = "registration of new user")
    fun register(@RequestBody userRequest: UserRequest) : User {
        val passHash = userRequest.password
        return userRepository.save(
            User(
                id = UUID.randomUUID(),
                login = userRequest.login,
                passwordHash = passHash,
                email = userRequest.email,
                createdDate = 14324324,
                updatedDate = 432432423
            )
        )
    }

    @RequestMapping(method = [RequestMethod.POST], value = ["/hello"])
    fun hello() : ErrorView {
        return ErrorView("hello")
    }

}