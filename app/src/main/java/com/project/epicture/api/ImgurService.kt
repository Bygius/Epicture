package com.project.epicture.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImgurService {
    public val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl("https://api.imgur.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
}