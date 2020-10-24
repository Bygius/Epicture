package com.project.epicture.homepage
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.epicture.R
import com.project.epicture.homepage.fragments.HomeFragment
import com.project.epicture.homepage.fragments.ProfileFragment
import com.project.epicture.homepage.fragments.UploadFragment
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
    }
}
