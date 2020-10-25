package com.project.epicture.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.ref.WeakReference
import androidx.appcompat.app.AppCompatActivity


class ImgurCalls {
    interface ResponseAccountImagesCallbacks {
        fun onResponse(images: ImgurModels.ResponseAccountImages?)
        fun onFailure()
    }
    interface ResponseAccountSettingsCallbacks {
        fun onResponse(images: ImgurModels.ResponseAccountSettings?)
        fun onFailure()
    }
    interface ResponseAccountAvatarCallbacks {
        fun onResponse(images: ImgurModels.ResponseAccountAvatar?)
        fun onFailure()
    }
    fun getAccountImage(callbacks: ResponseAccountImagesCallbacks, token: String?) {
        val callbacksWeakReference: WeakReference<ResponseAccountImagesCallbacks> = WeakReference<ResponseAccountImagesCallbacks>(callbacks)
        var imgur = ImgurService().retrofit.create(IImgurApi::class.java)
        val call: Call<ImgurModels.ResponseAccountImages> = imgur.getAccountImages("Bearer $token")
        call.enqueue(object: Callback<ImgurModels.ResponseAccountImages> {
            override fun onResponse(call: Call<ImgurModels.ResponseAccountImages>, response: Response<ImgurModels.ResponseAccountImages>) {
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onResponse(response.body())
                }
            }
            override fun onFailure(call: Call<ImgurModels.ResponseAccountImages>, t: Throwable) {
                println(t.message)
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onFailure()
                }
            }
        });
    }

    fun getAccountAvatar(callbacks: ResponseAccountAvatarCallbacks, token: String?) {
        val callbacksWeakReference: WeakReference<ResponseAccountAvatarCallbacks> = WeakReference<ResponseAccountAvatarCallbacks>(callbacks)
        var imgur = ImgurService().retrofit.create(IImgurApi::class.java)
        val call: Call<ImgurModels.ResponseAccountAvatar> = imgur.getAccountAvatar("Bearer $token", "Bygius")
        call.enqueue(object: Callback<ImgurModels.ResponseAccountAvatar> {
            override fun onResponse(call: Call<ImgurModels.ResponseAccountAvatar>, response: Response<ImgurModels.ResponseAccountAvatar>) {
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onResponse(response.body())
                }
            }
            override fun onFailure(call: Call<ImgurModels.ResponseAccountAvatar>, t: Throwable) {
                println(t.message)
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onFailure()
                }
            }
        });
    }
    fun getAccountSettings(callbacks: ResponseAccountSettingsCallbacks, token: String) {
        val callbacksWeakReference: WeakReference<ResponseAccountSettingsCallbacks> = WeakReference<ResponseAccountSettingsCallbacks>(callbacks)
        var imgur = ImgurService().retrofit.create(IImgurApi::class.java)
        val call: Call<ImgurModels.ResponseAccountSettings> = imgur.getAccountSettings("Bearer $token")
        call.enqueue(object: Callback<ImgurModels.ResponseAccountSettings> {
            override fun onResponse(call: Call<ImgurModels.ResponseAccountSettings>, response: Response<ImgurModels.ResponseAccountSettings>) {
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onResponse(response.body())
                }
            }
            override fun onFailure(call: Call<ImgurModels.ResponseAccountSettings>, t: Throwable) {
                println(t.message)
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onFailure()
                }
            }
        });
    }
}