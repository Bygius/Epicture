package com.project.epicture.homepage.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.project.epicture.R
import kotlinx.android.synthetic.main.fragment_home.*
import com.project.epicture.api.ImgurCalls
import com.project.epicture.api.ImgurModels
import com.project.epicture.utils.SharedPreference

class HomeFragment : Fragment() , ImgurCalls.ResponseSearchCallbacks {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    fun search(query : String)
    {
        val context: Context = this.context ?: return
        var token = SharedPreference(context).getValueString("access_token")
        ImgurCalls().getSearch(this, token,"hot", "0", query)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    search(query)
                }
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })
    }

    override fun onResponse(response: ImgurModels.ResponseSearch?) {
        if (response != null) {
            for (im in response.data)
                println(im.id)
        }
    }
    override fun onFailure() {
        println("======\n")
        println("-----> error\n")
    }

}
