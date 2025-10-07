package com.example.retroclean.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.retroclean.databinding.ActivityMainBinding
import com.example.retroclean.presentation.viewmodel.JokeViewModel
//This is clean, testable, and pure Retrofit-only Clean Architecture —
//no DI, no Room, no unnecessary layers.

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: JokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        //observation -->
        viewModel.joke.observe(this, Observer{
            binding.textView.text = it
        })

        //button click -->
        binding.buttonFetch.setOnClickListener {
            viewModel.fetchJoke()
        }
    }
}