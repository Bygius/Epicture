package com.project.epicture.homepage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.epicture.R
import com.project.epicture.homepage.ImageAdaptater
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment: Fragment() {
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

        val imageList = ArrayList<String>()
        imageList.add("https://www.imagesource.com/wp-content/uploads/2019/06/Rio.jpg")
        val igka = ImageAdaptater(requireContext(), imageList)
        rv.adapter = igka
    }
}
