package com.project.epicture.homepage.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.epicture.R
import com.project.epicture.api.uploadActivityFromCamera

import com.project.epicture.api.uploadActivityFromFile
import kotlinx.android.synthetic.main.fragment_upload.*

class UploadFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filebutton.setOnClickListener() {
            val intent = Intent(context, uploadActivityFromFile::class.java)
            startActivity(intent)
        }
        photobutton.setOnClickListener() {
            //val intent = Intent(context, uploadActivityFromCamera::class.java)
            //startActivityForResult(intent, 42)
        }
    }
}
