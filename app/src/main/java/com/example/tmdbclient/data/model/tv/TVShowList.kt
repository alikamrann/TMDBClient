package com.example.tmdbclient.data.model.tv


import com.google.gson.annotations.SerializedName

data class TVShowList(

    @SerializedName("results")
    val TVShows: List<TVShow>

)