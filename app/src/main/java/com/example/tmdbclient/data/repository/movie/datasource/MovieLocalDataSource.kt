package com.example.tmdbclient.data.repository.movie.datasource

import com.example.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMovieFromDB():List<Movie>
    suspend fun saveMovieToDB(movies: List<Movie>)
    suspend fun clearAll()
}