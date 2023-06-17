package com.example.tmdbclient.data.repository.movie

import android.util.Log
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieCashDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val moLocalDataSource: MovieLocalDataSource,
    private val movieCashDataSource: MovieCashDataSource
) : MovieRepository {



    override suspend fun getMovies(): List<Movie>? {

        return getMoviesFromChase()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        moLocalDataSource.clearAll()
        moLocalDataSource.saveMovieToDB(newListOfMovies)
        movieCashDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies

    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = moLocalDataSource.getMovieFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (movieList.size>0){
            return movieList
        }else{
            movieList=getMoviesFromAPI()
            moLocalDataSource.saveMovieToDB(movieList)

        }
        return movieList
    }
    suspend fun getMoviesFromChase():List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCashDataSource.getMoviesFromCash()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (movieList.size>0){
            return movieList
        }else{
            movieList=getMoviesFromDB()
            movieCashDataSource.saveMoviesToCache(movieList)

        }
        return movieList
    }
}