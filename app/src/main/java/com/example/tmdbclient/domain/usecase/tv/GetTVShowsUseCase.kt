package com.example.tmdbclient.domain.usecase.tv

import com.example.tmdbclient.data.model.tv.TVShow
import com.example.tmdbclient.domain.repository.TVShowRepository

class GetTVShowsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun execute():List<TVShow>? = tvShowRepository.getTVShows()
}