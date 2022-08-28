package com.example.appiniontest.ui.images.model

data class ImagesResponse(val id: String, val urls: Urls)
data class Urls(val raw: String, val full: String, val regular: String, val small: String, val thumb: String, val small_s3: String)
