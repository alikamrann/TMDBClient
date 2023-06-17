package com.example.tmdbclient.data.repository.movie.datasourcelmpl

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieCashDataSource

class MovieCacheDataSourceImpl : MovieCashDataSource {
    private var movieList = ArrayList<Movie >()
    override suspend fun getMoviesFromCash(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}