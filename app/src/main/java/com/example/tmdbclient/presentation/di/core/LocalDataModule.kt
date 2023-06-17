package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.dao.ArtistDao
import com.example.tmdbclient.data.dao.MovieDao
import com.example.tmdbclient.data.dao.TVDao
import com.example.tmdbclient.data.repository.artists.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artists.datasourcelmpl.ArtistLocalDataSourceImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasourcelmpl.MovieLocalDataSourceImpl
import com.example.tmdbclient.data.repository.tv.datasource.TVShowLocalDataSource
import com.example.tmdbclient.data.repository.tv.datasourcelmpl.TVShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao):ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTVShowLocalDataSource(tvDao: TVDao):TVShowLocalDataSource{
        return TVShowLocalDataSourceImpl(tvDao)
    }
}