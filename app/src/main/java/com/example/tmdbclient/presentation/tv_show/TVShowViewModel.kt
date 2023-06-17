package com.example.tmdbclient.presentation.tv_show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.domain.usecase.movies.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.movies.UpdateMoviesUseCase
import com.example.tmdbclient.domain.usecase.tv.GetTVShowsUseCase
import com.example.tmdbclient.domain.usecase.tv.UpdateTVShowUseCase

class TVShowViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowUseCase: UpdateTVShowUseCase
) : ViewModel() {
    fun getMovies() = liveData {
        val tvShowList=getTVShowsUseCase.execute()
        emit(tvShowList )
    }
    fun updateMovies() = liveData {
        val tvShowList = updateTVShowUseCase.execute()
        emit(tvShowList)
    }
}