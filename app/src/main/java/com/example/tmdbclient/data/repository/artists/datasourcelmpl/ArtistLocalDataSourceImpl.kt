package com.example.tmdbclient.data.repository.artists.datasourcelmpl

import com.example.tmdbclient.data.dao.ArtistDao
import com.example.tmdbclient.data.dao.MovieDao
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.artists.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {


    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDao.getArtist()
    }

    override suspend fun saveArtistToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artists )
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }
    }
}