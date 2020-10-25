package com.project.epicture.homepage.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.project.epicture.R
import com.project.epicture.R.layout.fragment_profile
import com.project.epicture.utils.SharedPreference
import com.project.epicture.api.ImgurCalls
import com.project.epicture.api.ImgurModels
import com.project.epicture.homepage.ImageAdaptater
import kotlinx.android.synthetic.main.fragment_test.*

class ProfileFragment: Fragment(), ImgurCalls.ResponseAccountImagesCallbacks, ImgurCalls.ResponseAccountAvatarCallbacks, ImgurCalls.ResponseSearchCallbacks, ImgurCalls.ResponseVoteCallbacks{

    val CLIENT_ID = "f78aba81ff33038"

    private var tool: Toolbar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val root = inflater.inflate(fragment_profile, container, false)
        val list = ArrayList<Fragment>()

        list.add(TestFragment())
        list.add(Test2Fragment())
        val page = root.findViewById<ViewPager>(R.id.page)

        page.adapter = object :
            FragmentPagerAdapter(childFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getItem(i: Int): Fragment {
                return list[i]
            }

            override fun getCount(): Int {
                return list.size
            }
        }
        val tab = root.findViewById<TabLayout>(R.id.tabs)
        tab.setupWithViewPager(page)
        tab.getTabAt(0)!!.text = "Post"
        tab.getTabAt(1)!!.text = "Favorite"
        tool = root.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tool?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.logout_button -> {
                    context?.let { SharedPreference(it).clearSharedPreference() }
                    activity?.finish()
                }
            }
            true
        }
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