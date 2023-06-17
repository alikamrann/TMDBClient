package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.repository.artists.ArtistRepositoryImpl
import com.example.tmdbclient.data.repository.artists.datasource.ArtistCashDataSource
import com.example.tmdbclient.data.repository.artists.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieCashDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.tv.TVShowRepositoryImpl
import com.example.tmdbclient.data.repository.tv.datasource.TVShowCashDataSource
import com.example.tmdbclient.data.repository.tv.datasource.TVShowLocalDataSource
import com.example.tmdbclient.data.repository.tv.datasource.TVShowRemoteDataSource
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TVShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCashDataSource: MovieCashDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCashDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTVShowRepository(
        tvaRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCashDataSource: TVShowCashDataSource
    ): TVShowRepositoryImpl {
        return TVShowRepositoryImpl(
            tvaRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCashDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCashDataSource: ArtistCashDataSource
    ): ArtistRepositoryImpl {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCashDataSource
        )
    }
}