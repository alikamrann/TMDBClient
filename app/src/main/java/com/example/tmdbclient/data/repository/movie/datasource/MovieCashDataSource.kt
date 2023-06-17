package com.example.tmdbclient.data.repository.movie.datasource

import com.example.tmdbclient.data.model.movie.Movie

interface MovieCashDataSource {
    suspend fun getMoviesFromCash():List<Movie>
    suspend fun saveMoviesToCache(movies : List<Movie>)
}