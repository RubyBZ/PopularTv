package com.example.populartv

import android.app.Application
import com.example.populartv.api.TelevisionService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TVApplication : Application() {

    lateinit var tvShowRepository: TVShowRepository

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val tvService = retrofit.create(TelevisionService::class.java)

        tvShowRepository = TVShowRepository(tvService)
    }
}