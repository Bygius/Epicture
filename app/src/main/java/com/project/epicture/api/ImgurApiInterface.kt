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
            @Header("Authorization") authHeader: String,
            @Path(value = "username", encoded = true) userId : String
    ): Call<ImgurModels.ResponseAccountAvatar>

    @GET("/3/account/{username}/favorites/{page}")
    fun getAccountFavorites(
            @Header("Authorization") authHeader: String,
            @Path(value = "username", encoded = true) userId : String,
            @Path(value = "page", encoded = true) page : String
    ): Call<ImgurModels.ResponseAccountFavorites>

    @GET("/3/gallery/search/{sort}/{window}/{page}")
    fun getSearch(
        @Header("Authorization") authHeader: String,
        @Path(value = "sort", encoded = true) userId : String,
        @Path(value = "page", encoded = true) page : String,
        @Query("q") query: String
    ): Call<ImgurModels.ResponseSearch>

    @GET("/3/gallery/{section}/{sort}/{page}")
    fun getViral(
        @Header("Authorization") authHeader: String,
        @Path(value = "section", encoded = true) section : String,
        @Path(value = "sort", encoded = true) sort : String,
        @Path(value = "page", encoded = true) page : String,
        @Query("showViral") show_viral: Boolean
    ): Call<ImgurModels.ResponseSearch>
    @Multipart
    @POST("3/upload")
    fun postImage(
            @Header("Authorization") authHeader: String,
            @Part file: MultipartBody.Part
    ): Call<ImgurModels.ResponseImage>

    @POST("/3/gallery/image/{id}/vote/{vote}")
    fun postVote(
            @Header("Authorization") authHeader: String,
            @Path(value = "id", encoded = true) image_id: String,
            @Path(value = "vote", encoded = true) vote : String
    ): Call<ImgurModels.ResponseVote>

    @POST("/3/image/{id}/favorite")
    fun postFavorite(
            @Header("Authorization") authHeader: String,
            @Path(value = "id", encoded = true) image_id: String
    ): Call<ImgurModels.ResponseFavorite>
    @DELETE("3/account/{username}/image/{hash}")
    fun deleteImage(
            @Header("Authorization") authHeader: String,
            @Path(value = "username", encoded = true) username: String,
            @Path(value = "hash", encoded = true) hash: String
    ): Call<ImgurModels.ResponseDelete>
}
