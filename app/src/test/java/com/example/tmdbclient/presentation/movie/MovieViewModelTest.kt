package com.example.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anushka.tmdbclient.getOrAwaitValue
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.FakeMovieRepository
import com.example.tmdbclient.domain.usecase.movies.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.movies.UpdateMoviesUseCase
import com.google.common.truth.Truth
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase  = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCase,updateMoviesUseCase)

    }

    @Test
    fun getMovies_returnCurrentList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1,"overview1","posterPath1","date1","title1"))
        movies.add(Movie(2,"overview2","posterPath2","date2","title2"))

        val currentList = viewModel.getMovies().getOrAwaitValue()

        Truth.assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnUpdateList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3,"overview3","posterPath3","date3","title3"))
        movies.add(Movie(4,"overview4","posterPath4","date4","title4"))

        val updateList = viewModel.updateMovies().getOrAwaitValue()

        Truth.assertThat(updateList  ).isEqualTo(movies)
    }

}