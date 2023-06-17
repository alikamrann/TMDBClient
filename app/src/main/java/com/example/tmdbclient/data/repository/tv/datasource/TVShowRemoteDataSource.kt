package com.example.tmdbclient.data.repository.tv.datasource

import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.tv.TVShow
import com.example.tmdbclient.data.model.tv.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTVShows(): Response<TVShowList>
}