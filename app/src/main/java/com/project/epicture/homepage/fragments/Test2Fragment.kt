package com.project.epicture.homepage.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.epicture.R
import com.project.epicture.api.ImgurCalls
import com.project.epicture.api.ImgurModels
import com.project.epicture.homepage.ImageAdaptater
import com.project.epicture.homepage.ImageFavoriteAdaptater
import com.project.epicture.utils.SharedPreference
import kotlinx.android.synthetic.main.fragment_test.*


class Test2Fragment : Fragment(), ImgurCalls.ResponseAccountFavoritesCallbacks {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
        val sglm = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rv.layoutManager = sglm
        val context: Context = this.context ?: return
        var token = SharedPreference(context).getValueString("access_token")
        var user_id = SharedPreference(context).getValueString("account_username")

        if (token != null) {
            if (user_id != null) {
                ImgurCalls().getAccountFavorites(this, token, user_id, "0")
            }
        }
    }
    override fun onResponse(response: ImgurModels.ResponseAccountFavorites?) {
        if (response != null) {
            val sglm = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            rv.layoutManager = sglm
            val imageList = response.data as MutableList<ImgurModels.ResponseAccountFavoritesData>
            val igka = ImageFavoriteAdaptater(requireContext(), imageList)
            rv.adapter = igka
        } else {
            println("YYYYYYYYYYYYYESSSSSSSSSSSSSSSSSs")
        }
    }
    override fun onFailure() {
        println("======\n")
        println("-----> error\n")
    }
}
