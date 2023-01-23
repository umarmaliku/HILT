package com.example.hilt.data.remote.api

import com.example.hilt.data.models.PhotoModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PhotoApiService {

    @GET("albums/1/photos")
    fun getPhoto(): Call<List<PhotoModel>>

    @POST("photos")
    fun sendPost(
        @Body photo: PhotoModel,
    ): Call<PhotoModel>
}