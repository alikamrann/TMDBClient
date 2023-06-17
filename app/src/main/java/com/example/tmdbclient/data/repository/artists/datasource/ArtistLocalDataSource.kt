package com.example.tmdbclient.data.repository.artists.datasource

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB():List<Artist>
    suspend fun saveArtistToDB(artists: List<Artist>)
    suspend fun clearAll()
}