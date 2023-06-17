package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.dao.ArtistDao
import com.example.tmdbclient.data.dao.MovieDao
import com.example.tmdbclient.data.dao.TVDao
import com.example.tmdbclient.data.repository.artists.datasource.ArtistCashDataSource
import com.example.tmdbclient.data.repository.artists.datasourcelmpl.ArtistCacheDataSourceImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieCashDataSource
import com.example.tmdbclient.data.repository.movie.datasourcelmpl.MovieCacheDataSourceImpl
import com.example.tmdbclient.data.repository.tv.datasource.TVShowCashDataSource
import com.example.tmdbclient.data.repository.tv.datasourcelmpl.TVShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CashDataModule {
    @Singleton
    @Provides
    fun provideMovieCashDataSource(movieDao: MovieDao):MovieCashDataSource{
        return MovieCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun provideArtistCashDataSource(artistDao: ArtistDao):ArtistCashDataSource{
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVShowCashDataSource(tvDao: TVDao):TVShowCashDataSource{
        return TVShowCacheDataSourceImpl()
    }
}