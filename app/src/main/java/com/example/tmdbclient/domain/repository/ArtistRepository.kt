package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.tv.TVShow

interface ArtistRepository {

    suspend fun getArtist():List<Artist>?

    suspend fun updateArtists():List<Artist>?
}