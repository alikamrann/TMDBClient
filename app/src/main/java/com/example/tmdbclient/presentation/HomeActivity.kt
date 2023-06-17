package com.example.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityHomeBinding
import com.example.tmdbclient.presentation.atrist.ArtistActivity
import com.example.tmdbclient.presentation.movie.MovieActivity
import com.example.tmdbclient.presentation.tv_show.TVShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.moviesButton.setOnClickListener{
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.tvShowButton.setOnClickListener{
            val intent = Intent(this, TVShowActivity::class.java)
            startActivity(intent)
        }

        binding.artsistButton.setOnClickListener{
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

    }
}