package com.example.appiniontest.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient private constructor(){
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient())
        .build()
    val api: ApiInterface
        get() = retrofit.create(ApiInterface::class.java)

    companion object {
        private const val BASE_URL = "https://api.unsplash.com/"
        private val mInstance: RetrofitClient = RetrofitClient()

        @get:Synchronized
        val instance: RetrofitClient
            get() {
                return mInstance
            }

        private fun okHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()
        }
    }

}