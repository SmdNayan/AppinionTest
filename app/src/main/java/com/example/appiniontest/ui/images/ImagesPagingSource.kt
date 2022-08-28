package com.example.appiniontest.ui.images

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.appiniontest.network.RetrofitClient
import com.example.appiniontest.ui.images.model.ImagesResponse

class ImagesPagingSource (): PagingSource<Int, ImagesResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImagesResponse> {

        return try {
            val page = params.key ?: 1
            val response = RetrofitClient.instance.api.getUnsplashImages("YyX9QhvZVUdXOncqvXqFjh4mAgZnxZpfn3T-emnhaJo", page)
            LoadResult.Page(data = response.body()!!, prevKey = if (page == 1) null else page - 1,
                nextKey = page + 1)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ImagesResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}