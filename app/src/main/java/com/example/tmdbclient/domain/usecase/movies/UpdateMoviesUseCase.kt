package com.example.tmdbclient.domain.usecase.movies

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}