package com.example.appiniontest.ui.images

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.appiniontest.ui.images.model.ImagesResponse

class ImagesViewModel(): ViewModel() {
    private val matchesRepo: ImagesRepo = ImagesRepo()

    val errorMessage = MutableLiveData<String>()

    fun getMovieList(): LiveData<PagingData<ImagesResponse>> {
        return matchesRepo.getAllImages().cachedIn(viewModelScope)
    }
}