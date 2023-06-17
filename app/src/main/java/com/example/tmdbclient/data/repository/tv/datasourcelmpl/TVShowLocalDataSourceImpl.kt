package com.example.tmdbclient.data.repository.tv.datasourcelmpl

import com.example.tmdbclient.data.dao.ArtistDao
import com.example.tmdbclient.data.dao.TVDao
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.tv.TVShow
import com.example.tmdbclient.data.repository.artists.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.tv.datasource.TVShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvDao: TVDao): TVShowLocalDataSource {




    override suspend fun getTVShowFromDB(): List<TVShow> {
        return tvDao.getTV()
    }

    override suspend fun saveTVShowToDB(tvShow: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.saveTV(tvShow )
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.deleteAllTV()
        }
    }
}