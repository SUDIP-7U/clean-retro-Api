package com.example.retroclean.data.remote

import retrofit2.http.GET

interface JokeApi {

    @GET("joke/Any")

    suspend fun getRandomJoke(): JokeDto

}
