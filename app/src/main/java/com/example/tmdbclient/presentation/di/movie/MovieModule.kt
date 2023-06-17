package com.example.tmdbclient.presentation.di.movie


import com.example.tmdbclient.domain.usecase.artists.GetArtistUseCase
import com.example.tmdbclient.domain.usecase.artists.UpdateArtistsUseCase
import com.example.tmdbclient.domain.usecase.movies.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.movies.UpdateMoviesUseCase
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}