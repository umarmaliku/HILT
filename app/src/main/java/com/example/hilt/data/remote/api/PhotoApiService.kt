package com.example.hilt.data.remote.api

import com.example.hilt.data.PhotoModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PhotoApiService {

    @GET("photo")
    fun getPhoto(

    ): Call<PhotoModel>

    @POST("photos")
    fun sendPost(
        @Body photo: PhotoModel,
    ) : Call<PhotoModel>
}