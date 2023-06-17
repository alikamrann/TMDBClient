package com.example.tmdbclient.data.dao

import android.provider.MediaStore.Audio.Artists
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tv.TVShow

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists:List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM popular_artist")
    suspend fun getArtist() : List<Artist>
}