package com.example.tmdbclient.data.repository.artists.datasourcelmpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class RemoteArtistDataSourceImpl(
    private val tmdbService: TMDBService, private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> =  tmdbService.getPopularActor(apiKey)
}