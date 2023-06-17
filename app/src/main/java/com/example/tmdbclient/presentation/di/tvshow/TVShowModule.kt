package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.domain.usecase.tv.GetTVShowsUseCase
import com.example.tmdbclient.domain.usecase.tv.UpdateTVShowUseCase
import com.example.tmdbclient.presentation.tv_show.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {
    @TVShowScope
    @Provides
    fun provideTVShowViewModelFactory(
        getTVShowsUseCase: GetTVShowsUseCase,
        updateTVShowUseCase: UpdateTVShowUseCase
    ): TVShowViewModelFactory {
        return TVShowViewModelFactory(
            getTVShowsUseCase,
            updateTVShowUseCase
        )
    }
}