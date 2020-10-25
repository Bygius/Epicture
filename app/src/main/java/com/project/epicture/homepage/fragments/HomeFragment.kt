package com.project.epicture.homepage.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.epicture.R
import com.project.epicture.api.ImgurCalls
import com.project.epicture.api.ImgurModels
import com.project.epicture.homepage.HomeAdaptater
import com.project.epicture.homepage.ImageAdaptater
import com.project.epicture.utils.SharedPreference
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_tab_layout.*

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
        ImgurCalls().getViral(this, token, "hot", "viral", "0", true)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  searchView = view.findViewById<SearchView>(R.id.search)
        val id = searchView.context.resources
            .getIdentifier("android:id/search_src_text", null, null)
        val textView = searchView.findViewById<View>(id) as TextView
        textView.setTextColor(Color.WHITE)
        val sglm = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rv_home.layoutManager = sglm
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
            val sglm = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            rv_home.layoutManager = sglm
            val imageList = response.data as MutableList<ImgurModels.ResponseSearchData>
            val igka = HomeAdaptater(requireContext(), imageList)
            rv_home.adapter = igka
        }
    }

    override fun onFailure() {

    }

}
