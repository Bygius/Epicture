package com.example.epicture.screens

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.epicture.R
import android.widget.Button
import android.view.View
import com.example.epicture.screens.login.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }


}