package com.example.populartv.api

import com.example.populartv.model.TVResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TelevisionService {

    @GET("tv/on_the_air")
    suspend fun getTVShows(@Query("api_key") apiKey: String): TVResponse
}