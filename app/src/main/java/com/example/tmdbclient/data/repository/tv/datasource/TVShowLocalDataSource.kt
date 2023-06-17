package com.example.tmdbclient.data.repository.tv.datasource

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.tv.TVShow

interface TVShowLocalDataSource {
    suspend fun getTVShowFromDB():List<TVShow>
    suspend fun saveTVShowToDB(artists: List<TVShow>)
    suspend fun clearAll()
}