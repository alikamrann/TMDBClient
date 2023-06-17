package com.example.tmdbclient.presentation.atrist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.domain.usecase.artists.GetArtistUseCase
import com.example.tmdbclient.domain.usecase.artists.UpdateArtistsUseCase
import com.example.tmdbclient.domain.usecase.movies.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.movies.UpdateMoviesUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {
    fun getMovies() = liveData {
        val artistList=getArtistUseCase.execute()
        emit(artistList )
    }
    fun updateMovies() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }
}