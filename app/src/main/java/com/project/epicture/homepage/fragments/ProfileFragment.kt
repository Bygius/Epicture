package com.project.epicture.homepage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.project.epicture.R
//import com.project.epicture.R.layout.fragment_profile
import com.project.epicture.utils.SharedPreference
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment: Fragment() {
    private var tool: Toolbar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        val list = ArrayList<Fragment>()

        list.add(PostFragment())
        list.add(FavoriteFragment())
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
    private fun update_username()
    {
        var name : String? = activity?.let { SharedPreference(it).getValueString("account_username") }
        if (name != null) {
            username.text = name
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        update_username()
        tool?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.logout_button -> {
                    context?.let { SharedPreference(it).clearSharedPreference() }
                    activity?.finish()
                }
            }
            true
        }
    }
}