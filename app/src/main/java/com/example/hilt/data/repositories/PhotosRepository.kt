package com.example.hilt.data.repositories

import com.example.hilt.data.models.PhotoModel
import com.example.hilt.data.remote.api.PhotoApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PhotosRepository @Inject constructor(private val apiService: PhotoApiService) {

    fun getPhoto(
        onSuccess: (photo: List<PhotoModel>) -> Unit,
        onFailure: (message: String) -> Unit,
    ) {
        apiService.getPhoto().enqueue(object : Callback<List<PhotoModel>> {
            override fun onResponse(
                call: Call<List<PhotoModel>>,
                response: Response<List<PhotoModel>>
            ) {
                response.body()?.let {
                    onSuccess(it)
                }
            }

            override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {
                t.localizedMessage?.let {
                    onFailure(it)
                }
            }
        })
    }

    fun sendPhoto(
        onSuccess: (photo: PhotoModel) -> Unit,
        onFailure: (message: String) -> Unit,
        photo: PhotoModel
    ) {
        apiService.sendPost(photo).enqueue(object : Callback<PhotoModel> {
            override fun onResponse(call: Call<PhotoModel>, response: Response<PhotoModel>) {
                response.body()?.let {
                    onSuccess(it)
                }
            }

            override fun onFailure(call: Call<PhotoModel>, t: Throwable) {
                t.localizedMessage?.let {
                    onFailure(it)
                }
            }
        })
    }
}