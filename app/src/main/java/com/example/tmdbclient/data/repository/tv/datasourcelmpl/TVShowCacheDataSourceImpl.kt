package com.example.tmdbclient.data.repository.tv.datasourcelmpl

import com.example.tmdbclient.data.model.tv.TVShow
import com.example.tmdbclient.data.repository.tv.datasource.TVShowCashDataSource

class TVShowCacheDataSourceImpl : TVShowCashDataSource {
    private var tvShowList = ArrayList<TVShow>()

    override suspend fun getTVFromCash(): List<TVShow> {
        return tvShowList
    }

    override suspend fun saveTVToCache(TVs: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(TVs)
    }

}