package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.artists.datasourcelmpl.RemoteArtistDataSourceImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.movie.datasourcelmpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService,apiKey
        )

    }

    @Provides
    @Singleton
    fun provideArtistRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return RemoteArtistDataSourceImpl(
            tmdbService,apiKey
        )

    }

    @Provides
    @Singleton
    fun provideTVShowRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return RemoteArtistDataSourceImpl(
            tmdbService,apiKey
        )

    }
}