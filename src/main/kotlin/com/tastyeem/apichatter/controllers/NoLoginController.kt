package com.tastyeem.apichatter.controllers


import com.tastyeem.apichatter.Strings
import com.tastyeem.apichatter.models.db.User
import com.tastyeem.apichatter.models.request.AuthRequest
import com.tastyeem.apichatter.models.request.UserRequest
import com.tastyeem.apichatter.models.view.BaseView
import com.tastyeem.apichatter.models.view.ErrorView
import com.tastyeem.apichatter.models.view.AuthView
import com.tastyeem.apichatter.repository.UserRepository
import com.tastyeem.apichatter.utils.SecurityUtils
import com.tastyeem.apichatter.utils.TimeUtils
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
    fun auth(@RequestBody authRequest: AuthRequest): ResponseEntity<AuthView> {
        val user = userRepository.findAll().firstOrNull{ user -> user.nickname == authRequest.nickname}
            ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        if(user.passwordHash == SecurityUtils().getStringHash(authRequest.password)) {
            val view = AuthView(user.id.toString(), TokenUtils().getJWTToken(authRequest.nickname) ?: "")
            return ResponseEntity.ok().body(view)
        }else{
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @RequestMapping(method = [RequestMethod.POST], value = ["/register"])
    @ApiOperation(value = "registration of new user")
    fun register(@RequestBody userRequest: UserRequest) : ResponseEntity<AuthView> {
        val time = TimeUtils().getUnixTime()
        if(userRepository.findAll().firstOrNull { user -> user.nickname == userRequest.nickname } != null){
            return ResponseEntity(HttpStatus.CONFLICT)
        }
        val user = userRepository.save(
            User(
                id = UUID.randomUUID(),
                nickname = userRequest.nickname,
                passwordHash = SecurityUtils().getStringHash(userRequest.password),
                email = userRequest.email,
                createdDate = time,
                updatedDate = time
            )
        )
        return ResponseEntity.ok().body(AuthView(user.id.toString(),TokenUtils().getJWTToken(user.id.toString()) ?: ""))
    }

}