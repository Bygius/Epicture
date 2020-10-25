package com.project.epicture.homepage.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.epicture.R
import com.project.epicture.homepage.ImageAdaptater
import kotlinx.android.synthetic.main.fragment_profile.*
import com.project.epicture.api.*
import com.project.epicture.utils.SharedPreference

class ProfileFragment: Fragment(), ImgurCalls.ResponseAccountImagesCallbacks, ImgurCalls.ResponseAccountAvatarCallbacks, ImgurCalls.ResponseSearchCallbacks, ImgurCalls.ResponseVoteCallbacks{
    val CLIENT_ID = "f78aba81ff33038"

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
        val sglm = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rv.layoutManager = sglm
        val context: Context = this.context ?: return
        var token = SharedPreference(context).getValueString("access_token")
        //ImgurCalls().getSearch(this, token)
        ImgurCalls().getAccountImage(this, token)
        //ImgurCalls().getAccountAvatar(this, token)
        ImgurCalls().postVote(this, token, "qPJSLjN","veto")
        //ImgurCalls().getSearch(this, token)
    }
    override fun onResponse(response: ImgurModels.ResponseAccountImages?) {
        if (response != null) {
            val sglm = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            rv.layoutManager = sglm
            val imageList : List<ImgurModels.AccountImagesData> = response.data
            //for (im in imageList) {
            //    println("=== " + im.id + "\n")
            //}
            val igka = ImageAdaptater(requireContext(), imageList)
            rv.adapter = igka
        }
    }
    override fun onResponse(response: ImgurModels.ResponseAccountAvatar?) {
        if (response != null) {
            println(response.data)
        }
    }
    override fun onResponse(response: ImgurModels.ResponseSearch?) {
        if (response != null) {
            //println(response.data)
            //for (im in response.data)
            //    println(im.id)
        }
    }

    override fun onResponse(response: ImgurModels.ResponseVote?) {
        if (response != null) {
        //    println(response.data)
            //for (im in response.data)
            //    println(im.id)
        }
    }
    override fun onFailure() {
        println("======\n")
        println("-----> error\n")
    }
}
