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
    interface ResponseAccountFavoritesCallbacks {
        fun onResponse(images: ImgurModels.ResponseAccountFavorites?)
        fun onFailure()
    }
    interface ResponseSearchCallbacks {
        fun onResponse(images: ImgurModels.ResponseSearch?)
        fun onFailure()
    }
    interface ResponseViralCallbacks {
        fun onResponse(images: ImgurModels.ResponseVote?)
        fun onFailure()
    }
    interface ResponseVoteCallbacks {
        fun onResponse(images: ImgurModels.ResponseVote?)
        fun onFailure()
    }
    interface ResponseFavoriteCallbacks {
        fun onResponse(images: ImgurModels.ResponseFavorite?)
        fun onFailure()
    }
    interface ResponseDeleteCallbacks {
        fun onResponse(images: ImgurModels.ResponseDelete?)
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
    fun getAccountFavorites(callbacks: ResponseAccountFavoritesCallbacks, token: String, user_id: String, page: String) {
        val callbacksWeakReference: WeakReference<ResponseAccountFavoritesCallbacks> = WeakReference<ResponseAccountFavoritesCallbacks>(callbacks)
        var imgur = ImgurService().retrofit.create(IImgurApi::class.java)
        val call: Call<ImgurModels.ResponseAccountFavorites> = imgur.getAccountFavorites("Bearer $token", user_id, page)
        call.enqueue(object: Callback<ImgurModels.ResponseAccountFavorites> {
            override fun onResponse(call: Call<ImgurModels.ResponseAccountFavorites>, response: Response<ImgurModels.ResponseAccountFavorites>) {
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onResponse(response.body())
                }
            }
            override fun onFailure(call: Call<ImgurModels.ResponseAccountFavorites>, t: Throwable) {
                println(t.message)
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onFailure()
                }
            }
        });
    }
    fun getSearch(callbacks: ResponseSearchCallbacks, token: String?, sort: String, page : String, query : String) {
        val callbacksWeakReference: WeakReference<ResponseSearchCallbacks> = WeakReference<ResponseSearchCallbacks>(callbacks)
        var imgur = ImgurService().retrofit.create(IImgurApi::class.java)
        val call: Call<ImgurModels.ResponseSearch> = imgur.getSearch("Bearer $token", sort, page, query)
        call.enqueue(object: Callback<ImgurModels.ResponseSearch> {
            override fun onResponse(call: Call<ImgurModels.ResponseSearch>, response: Response<ImgurModels.ResponseSearch>) {
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onResponse(response.body())
                }
            }
            override fun onFailure(call: Call<ImgurModels.ResponseSearch>, t: Throwable) {
                println(t.message)
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onFailure()
                }
            }
        });
    }
    fun getViral(callbacks: ResponseSearchCallbacks, token: String?, section: String, sort: String, page : String, show_viral : Boolean) {
        val callbacksWeakReference: WeakReference<ResponseSearchCallbacks> = WeakReference<ResponseSearchCallbacks>(callbacks)
        var imgur = ImgurService().retrofit.create(IImgurApi::class.java)
        val call: Call<ImgurModels.ResponseSearch> = imgur.getViral("Bearer $token", section, sort, page, show_viral)
        call.enqueue(object: Callback<ImgurModels.ResponseSearch> {
            override fun onResponse(call: Call<ImgurModels.ResponseSearch>, response: Response<ImgurModels.ResponseSearch>) {
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onResponse(response.body())
                }
            }
            override fun onFailure(call: Call<ImgurModels.ResponseSearch>, t: Throwable) {
                println(t.message)
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onFailure()
                }
            }
        });
    }
    fun postVote(callbacks: ResponseVoteCallbacks, token: String?, image_id: String, vote: String) {
        val callbacksWeakReference: WeakReference<ResponseVoteCallbacks> = WeakReference<ResponseVoteCallbacks>(callbacks)
        var imgur = ImgurService().retrofit.create(IImgurApi::class.java)
        val call: Call<ImgurModels.ResponseVote> = imgur.postVote("Bearer $token", image_id, vote)
        call.enqueue(object: Callback<ImgurModels.ResponseVote> {
            override fun onResponse(call: Call<ImgurModels.ResponseVote>, response: Response<ImgurModels.ResponseVote>) {
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onResponse(response.body())
                }
            }
            override fun onFailure(call: Call<ImgurModels.ResponseVote>, t: Throwable) {
                println(t.message)
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onFailure()
                }
            }
        });
    }
    fun postFavorite(callbacks: ResponseFavoriteCallbacks, token: String?, image_id: String) {
        val callbacksWeakReference: WeakReference<ResponseFavoriteCallbacks> = WeakReference<ResponseFavoriteCallbacks>(callbacks)
        var imgur = ImgurService().retrofit.create(IImgurApi::class.java)
        val call: Call<ImgurModels.ResponseFavorite> = imgur.postFavorite("Bearer $token", image_id)
        call.enqueue(object: Callback<ImgurModels.ResponseFavorite> {
            override fun onResponse(call: Call<ImgurModels.ResponseFavorite>, response: Response<ImgurModels.ResponseFavorite>) {
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onResponse(response.body())
                }
            }
            override fun onFailure(call: Call<ImgurModels.ResponseFavorite>, t: Throwable) {
                println(t.message)
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onFailure()
                }
            }
        });
    }
    fun delete(callbacks: ResponseDeleteCallbacks, token: String?, username: String, hash: String) {
        val callbacksWeakReference: WeakReference<ResponseDeleteCallbacks> = WeakReference<ResponseDeleteCallbacks>(callbacks)
        var imgur = ImgurService().retrofit.create(IImgurApi::class.java)
        val call: Call<ImgurModels.ResponseDelete> = imgur.deleteImage("Bearer $token", username, hash)
        call.enqueue(object: Callback<ImgurModels.ResponseDelete> {
            override fun onResponse(call: Call<ImgurModels.ResponseDelete>, response: Response<ImgurModels.ResponseDelete>) {
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onResponse(response.body())
                }
            }
            override fun onFailure(call: Call<ImgurModels.ResponseDelete>, t: Throwable) {
                println(t.message)
                if (callbacksWeakReference != null) {
                    callbacksWeakReference.get()?.onFailure()
                }
            }
        });
    }
}