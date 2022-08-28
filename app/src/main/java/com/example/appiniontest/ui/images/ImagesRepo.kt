package com.example.appiniontest.ui.images

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.appiniontest.ui.images.model.ImagesResponse

class ImagesRepo {
    fun getAllImages(): LiveData<PagingData<ImagesResponse>> {

        return Pager(
            config = PagingConfig(
                pageSize = 100,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                ImagesPagingSource()
            }
            , initialKey = 1
        ).liveData
    }
}