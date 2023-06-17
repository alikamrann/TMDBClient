package com.example.tmdbclient.data.repository.artists.datasourcelmpl

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.artists.datasource.ArtistCashDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieCashDataSource

class ArtistCacheDataSourceImpl : ArtistCashDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCash(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }

}