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

    @GET("/3/account/{username}/avatar")
    fun getAccountAvatar(
            @Header("Authorization") authHeader: String, @Path(value = "username", encoded = true) userId : String
    ): Call<ImgurModels.ResponseAccountAvatar>

    @Multipart
    @POST("3/upload")
    fun postImage(
            @Header("Authorization") authHeader: String,
            @Part file: MultipartBody.Part
    ): Call<ImgurModels.ResponseImage>
}
