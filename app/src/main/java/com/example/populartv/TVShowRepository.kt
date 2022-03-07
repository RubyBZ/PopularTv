package com.example.populartv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.populartv.api.TelevisionService
import com.example.populartv.model.TVShow

class TVShowRepository(private val tvService: TelevisionService) {
    private val apiKey = "ca72407c9de7743fd5c4c8634e7d2276"

    private val tvShowsLiveData = MutableLiveData<List<TVShow>>()
    private val errorLiveData = MutableLiveData<String>()

    val tvShows: LiveData<List<TVShow>>
        get() = tvShowsLiveData

    val error: LiveData<String>
        get() = errorLiveData

    suspend fun fetchTVShows() {
        try {
            val shows = tvService.getTVShows(apiKey)
            tvShowsLiveData.postValue(shows.results)
        } catch (exception: Exception) {
            errorLiveData.postValue("An error occurred: ${exception.message}")
        }
    }
}