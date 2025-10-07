package com.example.retroclean.data.repository

import com.example.retroclean.data.remote.JokeApi
import com.example.retroclean.domain.model.Joke
import com.example.retroclean.domain.repository.JokeRepository

class JokeRepositoryImpl(
    private val api: JokeApi
) : JokeRepository {
    override suspend fun getRandomJoke(): Joke {
        return api.getRandomJoke().toDomain()
    }
}