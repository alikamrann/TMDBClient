package com.example.tmdbclient.data.repository.tv

import android.util.Log
import com.example.tmdbclient.data.model.tv.TVShow
import com.example.tmdbclient.data.repository.tv.datasource.TVShowCashDataSource
import com.example.tmdbclient.data.repository.tv.datasource.TVShowLocalDataSource
import com.example.tmdbclient.data.repository.tv.datasource.TVShowRemoteDataSource
import com.example.tmdbclient.domain.repository.TVShowRepository

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCashDataSource: TVShowCashDataSource
) : TVShowRepository {




    suspend fun getTVShowsFromAPI(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getTVShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.TVShows
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        return tvShowList
    }

    suspend fun getTVShowsFromDB(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowLocalDataSource.getTVShowFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList=getTVShowsFromAPI()
            tvShowLocalDataSource.saveTVShowToDB(tvShowList)

        }
        return tvShowList
    }
    suspend fun geTVShowsFromChase():List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowCashDataSource.getTVFromCash()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList=getTVShowsFromDB()
            tvShowCashDataSource.saveTVToCache(tvShowList)

        }
        return tvShowList
    }

    override suspend fun getTVShows(): List<TVShow>? {
        return geTVShowsFromChase()
    }

    override suspend fun updateTVShows(): List<TVShow>? {
        val newListOfTVShow = getTVShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowToDB(newListOfTVShow)
        tvShowCashDataSource.saveTVToCache(newListOfTVShow)
        return newListOfTVShow
    }


}