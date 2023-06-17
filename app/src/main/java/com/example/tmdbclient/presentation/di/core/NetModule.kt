package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl : String) {


    private val  interceptor = HttpLoggingInterceptor().apply {
        this.level= HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder().apply {
        this.addInterceptor(MyInspector()).
            addInterceptor(interceptor)
        connectTimeout(30, TimeUnit.SECONDS).
        readTimeout(30, TimeUnit.SECONDS).
        writeTimeout(30, TimeUnit.SECONDS)
    }.build()


    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
    }
    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit):TMDBService{
        return retrofit.create(TMDBService::class.java)
    }


}
class MyInspector : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =chain.request().newBuilder().
        addHeader("accept","application/json")
            .build()
        return chain.proceed(request)
    }
}