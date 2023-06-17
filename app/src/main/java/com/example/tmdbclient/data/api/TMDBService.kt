package com.example.tmdbclient.data.api

import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.model.tv.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Header("Authorization")authorization : String):Response<MovieList>

    @GET("discover/tv")
    suspend fun getPopularTVShows(@Header("Authorization")authorization : String):Response<TVShowList>

    @GET("person/popular")
    suspend fun getPopularActor(@Header("Authorization")authorization : String):Response<ArtistList>
}