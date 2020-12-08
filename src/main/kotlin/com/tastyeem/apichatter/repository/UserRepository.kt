package com.tastyeem.apichatter.repository

import com.tastyeem.apichatter.models.db.User
import com.tastyeem.apichatter.models.request.UserRequest
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : MongoRepository<User, String>{

}