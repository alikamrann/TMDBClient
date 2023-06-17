package com.example.tmdbclient.presentation.tv_show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.movies.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.movies.UpdateMoviesUseCase
import com.example.tmdbclient.domain.usecase.tv.GetTVShowsUseCase
import com.example.tmdbclient.domain.usecase.tv.UpdateTVShowUseCase

class TVShowViewModelFactory(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowUseCase: UpdateTVShowUseCase,
) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowViewModel(getTVShowsUseCase,updateTVShowUseCase) as T
    }
}