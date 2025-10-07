package com.example.retroclean.data.remote

import com.example.retroclean.domain.model.Joke

data class JokeDto(
    val id: Int,
    val type: String,
    val setup: String?,
    val delivery: String?
) {
    fun toDomain() = Joke(id, type, setup, delivery)
}