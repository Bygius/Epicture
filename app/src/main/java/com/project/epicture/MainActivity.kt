package com.project.epicture

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.project.epicture.api.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Callback
import retrofit2.Response
import com.project.epicture.utils.SharedPreference
import com.project.epicture.api.uploadActivity
import android.content.pm.PackageManager
import com.project.epicture.homepage.HomePageActivity
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    //private var access_token : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //val shared:SharedPreference = SharedPreference(this)
        //shared.clearSharedPreference().getValueString("access_token")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (SharedPreference(this).getValueString("access_token") != null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        //val shared:SharedPreference = SharedPreference(this)
        //val tok = shared.getValueString("access_token")
        //if (tok == null)
        //    return
  /*      findViewById<Button>(R.id.upload_button).setOnClickListener {
            val intent = Intent(this, uploadActivity::class.java)
            startActivity(intent)
        }*/
        //ImgurCalls().getAccountImage(this, tok)
        //ImgurCalls().getAccountSettings(this, tok)
        if (SharedPreference(this).getValueString("access_token") == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
}