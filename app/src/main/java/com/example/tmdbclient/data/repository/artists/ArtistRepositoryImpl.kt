package com.example.tmdbclient.data.repository.artists

import android.util.Log
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.artists.datasource.ArtistCashDataSource
import com.example.tmdbclient.data.repository.artists.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCashDataSource: ArtistCashDataSource
) : ArtistRepository {




    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (artistList.size>0){
            return artistList
        }else{
            artistList=getArtistsFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)

        }
        return artistList
    }
    suspend fun getArtistsFromChase():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCashDataSource.getArtistFromCash()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (artistList.size>0){
            return artistList
        }else{
            artistList=getArtistsFromDB()
            artistCashDataSource.saveArtistToCache(artistList)

        }
        return artistList
    }

    override suspend fun getArtist(): List<Artist>? {
        return getArtistsFromChase()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtists)
        artistCashDataSource.saveArtistToCache(newListOfArtists)
        return newListOfArtists
    }
}