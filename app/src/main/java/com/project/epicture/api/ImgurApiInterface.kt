package com.project.epicture.api
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface IImgurApi {
    @GET("/3/account/me/settings")
    fun getAccountSettings(
        @Header("Authorization") authHeader: String
    ): Call<ImgurModels.ResponseAccountSettings>

    @GET("/3/account/me/images")
    fun getAccountImages(
        @Header("Authorization") authHeader: String
    ): Call<ImgurModels.ResponseAccountImages>

    @Multipart
    @POST("3/upload")
    fun postImage(
            @Header("Authorization") authHeader: String,
            @Part file: MultipartBody.Part
    ): Call<ImgurModels.ResponseImage>
}
