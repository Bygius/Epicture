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

class ProfileFragment: Fragment(), ImgurCalls.ResponseAccountImagesCallbacks, ImgurCalls.ResponseAccountAvatarCallbacks {
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
        ImgurCalls().getAccountImage(this, token)
        ImgurCalls().getAccountAvatar(this, token)
    }
    override fun onResponse(response: ImgurModels.ResponseAccountImages?) {
        if (response != null) {
            val sglm = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            rv.layoutManager = sglm
            val imageList = ArrayList<String>()
            for (r in response.data) {
                imageList.add(r.link)
            }
            val igka = ImageAdaptater(requireContext(), imageList)
            rv.adapter = igka
        }
    }
    override fun onResponse(response: ImgurModels.ResponseAccountAvatar?) {
        if (response != null) {
            println(response.data)
        }
    }
    override fun onFailure() {
        println("======\n")
        println("-----> error\n")
    }
}
