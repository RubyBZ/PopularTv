package com.example.populartv.model

data class TVResponse(
    val page: Int,
    val results: List<TVShow>
)