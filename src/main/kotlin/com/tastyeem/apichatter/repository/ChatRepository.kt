package com.tastyeem.apichatter.repositoryimport com.tastyeem.apichatter.models.db.Chatimport org.springframework.data.mongodb.repository.MongoRepositoryimport org.springframework.stereotype.Repository@Repositoryinterface ChatRepository : MongoRepository<Chat, String>{}