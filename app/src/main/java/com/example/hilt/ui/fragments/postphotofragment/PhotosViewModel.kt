package com.example.hilt.ui.fragments.postphotofragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hilt.data.PhotoModel
import com.example.hilt.data.repositories.PhotosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(private val repository: PhotosRepository):ViewModel() {

    private val _photoLiveData = MutableLiveData<PhotoModel>()
    val photoLiveData: LiveData <PhotoModel> = _photoLiveData

    fun sendPhoto(albumId:Int, id :Int,title : String, url :String,thumbnailUrl:String){
        repository.sendPhoto(
            onSuccess = {
                _photoLiveData.value = it
            },
            onFailure = {

            },
            photo = PhotoModel (albumId,id,title, url ,thumbnailUrl)
        )
    }
}