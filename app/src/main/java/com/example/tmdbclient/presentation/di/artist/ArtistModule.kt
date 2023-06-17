package com.example.tmdbclient.presentation.di.artist

import com.example.tmdbclient.domain.usecase.artists.GetArtistUseCase
import com.example.tmdbclient.domain.usecase.artists.UpdateArtistsUseCase
import com.example.tmdbclient.presentation.atrist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistsUseCase
        )
    }
}