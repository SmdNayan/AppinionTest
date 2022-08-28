package com.example.appiniontest.network

import com.example.appiniontest.ui.images.model.ImagesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("photos")
    suspend fun getUnsplashImages(
        @Query("client_id") client_id: String,
        @Query("page") page: Int
    ): Response<List<ImagesResponse>>

}