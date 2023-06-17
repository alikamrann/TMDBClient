package com.example.tmdbclient.data.repository.tv.datasourcelmpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.tv.TVShowList
import com.example.tmdbclient.data.repository.tv.datasource.TVShowRemoteDataSource
import retrofit2.Response


class RemoteTVShowDataSourceImpl(
    private val tmdbService: TMDBService, private val apiKey: String
) : TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShowList> =  tmdbService.getPopularTVShows(apiKey)


}