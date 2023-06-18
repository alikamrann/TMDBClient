package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.tv.TVShow

interface TVShowRepository {

    suspend fun getTVShows():List<TVShow>?

    suspend fun updateTVShows():List<TVShow>?
}