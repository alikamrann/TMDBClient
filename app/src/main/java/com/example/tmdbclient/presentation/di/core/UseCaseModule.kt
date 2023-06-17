package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TVShowRepository
import com.example.tmdbclient.domain.usecase.artists.GetArtistUseCase
import com.example.tmdbclient.domain.usecase.artists.UpdateArtistsUseCase
import com.example.tmdbclient.domain.usecase.movies.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.movies.UpdateMoviesUseCase
import com.example.tmdbclient.domain.usecase.tv.GetTVShowsUseCase
import com.example.tmdbclient.domain.usecase.tv.UpdateTVShowUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TVShowRepository):GetTVShowsUseCase{
        return GetTVShowsUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TVShowRepository):UpdateTVShowUseCase{
        return UpdateTVShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }
}