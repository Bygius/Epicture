package com.project.epicture.api

import android.net.Uri
import android.os.FileUtils
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.lang.ref.WeakReference
import android.content.Context
import android.content.ContentResolver
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

    fun getAccountImage(callbacks: ResponseAccountImagesCallbacks, token: String) {
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
/*    fun postImage(callbacks: ResponseImageCallbacks, token: String, file_uri: Uri) {

        val callbacksWeakReference: WeakReference<ResponseImageCallbacks> = WeakReference<ResponseImageCallbacks>(callbacks)
        var imgur = ImgurService().retrofit.create(IImgurApi::class.java)
        println("1\n")
        var file : File = File(file_uri.path)
        //(file_uri.path)
        //val inputStream = contentResolver.openInputStream(Uri.fromFile(file))
        //val requestFile = RequestBody.create(MediaType.parse("image/jpeg"), getBytes(inputStream))

        //var requestFile: RequestBody = RequestBody.create(MediaType.parse("image/jpeg"), file)
        //println("2\n")

        //var body : MultipartBody.Part = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
        //println("3\n")

        //val call: Call<ImgurModels.ResponseImage> = imgur.postImage("Bearer $token",body)//imgur.getAccountSettings("Bearer $token")
        println("4\n")
       //val file = File(profileImagePath)
        val inputStream = contentResolver.openInputStream(Uri.fromFile(file))
        val requestFile = RequestBody.create(MediaType.parse("image/jpeg"), getBytes(inputStream))
        body = MultipartBody.Part.createFormData("image", file.name, requestFile)

        call.enqueue(object: Callback<ImgurModels.ResponseImage> {
            override fun onResponse(call: Call<ImgurModels.ResponseImage>, response: Response<ImgurModels.ResponseImage>) {
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onResponse(response.body())
                }
            }
            override fun onFailure(call: Call<ImgurModels.ResponseImage>, t: Throwable) {
                println(t.message)
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onFailure()
                }
            }
        });
    }*/
}