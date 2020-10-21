package com.example.epicture.screens.login
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.epicture.R
import android.view.View

class LoginActivity : AppCompatActivity() {

    val CLIENT_ID = "f78aba81ff33038"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById<Button>(R.id.login_button).setOnClickListener {
            val url = "https://api.imgur.com/oauth2/authorize?client_id=f78aba81ff33038&response_type=token"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    protected override fun onResume() {
        super.onResume()
        if (intent != null && intent.getAction().equals(Intent.ACTION_VIEW)) {
            val uri = intent.data
            println(uri)
        }
    }

}