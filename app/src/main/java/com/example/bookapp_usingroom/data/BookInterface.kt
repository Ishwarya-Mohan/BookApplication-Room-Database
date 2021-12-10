package com.example.bookapp_usingroom.data

import com.example.bookapp_usingroom.data.Alldetails

import retrofit2.http.GET

interface BookInterface {
    @GET("/books")
    suspend fun getBooks():List<Alldetails>
}