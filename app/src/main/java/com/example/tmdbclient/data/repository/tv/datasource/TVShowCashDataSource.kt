package com.example.tmdbclient.data.repository.tv.datasource

import com.example.tmdbclient.data.model.tv.TVShow

interface TVShowCashDataSource {
    suspend fun getTVFromCash():List<TVShow>
    suspend fun saveTVToCache(TVs : List<TVShow>)
}