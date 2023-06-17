package com.example.tmdbclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityHomeBinding
import com.example.tmdbclient.databinding.ActivityMovieBinding
import com.example.tmdbclient.presentation.di.Injector

import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var moViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        moViewModel = ViewModelProvider(this,factory)[MovieViewModel::class.java]

        val responseLiveData = moViewModel.getMovies()
        responseLiveData.observe(this, Observer{
            Log.i("MyTag",it.toString())
        })
    }
}