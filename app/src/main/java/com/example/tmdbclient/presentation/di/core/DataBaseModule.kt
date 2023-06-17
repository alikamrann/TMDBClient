package com.example.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.dao.ArtistDao
import com.example.tmdbclient.data.dao.MovieDao
import com.example.tmdbclient.data.dao.TMDBDatabase
import com.example.tmdbclient.data.dao.TVDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {
    @Provides
    @Singleton
    fun provideMovieDatabase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient").build()
    }
    @Provides
    @Singleton
    fun provideMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Provides
    @Singleton
    fun provideArtistDao(tmdbDatabase: TMDBDatabase) : ArtistDao{
        return tmdbDatabase.artistDao()
    }

    @Provides
    @Singleton
    fun provideTVShowDao(tmdbDatabase: TMDBDatabase) : TVDao{
        return tmdbDatabase.tvDao()
    }

}