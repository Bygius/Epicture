package com.project.epicture.homepage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.project.epicture.R
import com.project.epicture.homepage.fragments.HomeFragment
import com.project.epicture.homepage.fragments.ProfileFragment
import com.project.epicture.homepage.fragments.UploadFragment
import com.google.android.material.tabs.TabLayout
import com.project.epicture.utils.SharedPreference
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.fragment_profile.*
import com.project.epicture.api.ImgurCalls

class HomePageActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val homeFragment = HomeFragment()
        val uploadFragment = UploadFragment()
        val profileFragment = ProfileFragment()
        makeCurrentFragment(homeFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_account -> makeCurrentFragment(profileFragment)
                R.id.ic_upload -> makeCurrentFragment(uploadFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, fragment)
                commit()
            }
}
