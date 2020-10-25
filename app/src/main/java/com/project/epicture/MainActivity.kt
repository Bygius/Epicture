package com.project.epicture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.epicture.utils.SharedPreference
import com.project.epicture.homepage.HomePageActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
        if (SharedPreference(this).getValueString("access_token") == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
}