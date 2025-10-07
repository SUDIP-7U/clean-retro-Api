package com.example.retroclean.domain.repository

import com.example.retroclean.domain.model.Joke


interface JokeRepository {

    suspend fun getRandomJoke(): Joke

}
