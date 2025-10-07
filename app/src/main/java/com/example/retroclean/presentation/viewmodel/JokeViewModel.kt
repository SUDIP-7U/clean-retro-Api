package com.example.retroclean.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retroclean.data.repository.JokeRepositoryImpl
import com.example.retroclean.utils.RetrofitInstance
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {

    private val repository = JokeRepositoryImpl(RetrofitInstance.api)

    private val _joke = MutableLiveData<String>()
    val joke: LiveData<String> = _joke

    fun fetchJoke() {
        viewModelScope.launch {
            try {
                val result = repository.getRandomJoke()
                _joke.value = result.setup ?: "No setup"
            } catch (e: Exception) {
                _joke.value = "Error: ${e.message}"
            }
        }
    }
}