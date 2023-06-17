package com.example.tmdbclient.data.repository.artists.datasource

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie

interface ArtistCashDataSource {
    suspend fun getArtistFromCash():List<Artist>
    suspend fun saveArtistToCache(artists : List<Artist>)
}