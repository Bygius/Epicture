package com.project.epicture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.epicture.utils.SharedPreference
import com.project.epicture.homepage.HomePageActivity

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