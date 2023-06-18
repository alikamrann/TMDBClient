package com.example.tmdbclient.presentation.tv_show

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.tv.GetTVShowsUseCase
import com.example.tmdbclient.domain.usecase.tv.UpdateTVShowUseCase

class TVShowViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowUseCase: UpdateTVShowUseCase
) : ViewModel() {
    fun getTVShows() = liveData {
        val tvShowList=getTVShowsUseCase.execute()
        emit(tvShowList )
    }
    fun updateTVShows() = liveData {
        val tvShowList = updateTVShowUseCase.execute()
        emit(tvShowList)
    }
}