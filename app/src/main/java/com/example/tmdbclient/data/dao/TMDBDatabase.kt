package com.example.tmdbclient.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tv.TVShow

@Database(entities = [Movie::class,TVShow::class,Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TVDao
    abstract fun artistDao(): ArtistDao
}