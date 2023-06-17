package com.example.tmdbclient.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tv.TVShow

@Dao
interface TVDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTV(movies:List<TVShow>)

    @Query("DELETE FROM popular_tv")
    suspend fun deleteAllTV()

    @Query("SELECT * FROM popular_tv")
    suspend fun getTV() : List<TVShow>
}