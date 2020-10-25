package com.project.epicture.homepage
import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.epicture.R
import com.project.epicture.api.ImgurCalls
import com.project.epicture.api.ImgurModels
import com.project.epicture.utils.SharedPreference
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ImageActivity : AppCompatActivity() , ImgurCalls.ResponseFavoriteCallbacks, ImgurCalls.ResponseDeleteCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        val path = intent.extras?.getString("path")
        val id =  intent.extras?.getString("id")
        val image = findViewById<ImageView>(R.id.imageView2);
        Picasso.with(baseContext).load(path).into(image);
        val bar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar2)
        textView.text = intent.extras?.getString("title")
        views.text = intent.extras?.getInt("views").toString()
        like.text = intent.extras?.getInt("like").toString()
        dislike.text = intent.extras?.getInt("dislike").toString()
        bar.setNavigationOnClickListener() {
            finish()
        }
        val favorite = findViewById<FloatingActionButton>(R.id.favoriteButton)
        favorite.setOnClickListener() {
            favorite()
        }
        val del = findViewById<FloatingActionButton>(R.id.deleteButton)
        del.setOnClickListener() {
            delete()
        }
    }
    private fun favorite() {
        val context: Context = applicationContext //context ?: return
        var token = SharedPreference(context).getValueString("access_token")
        var id = intent.extras?.getString("id")
        if (id != null) {
            ImgurCalls().postFavorite(this, token, id)
        }
    }
    private fun delete() {
        val context: Context = applicationContext //context ?: return
        var token = SharedPreference(context).getValueString("access_token")
        var hash = intent.extras?.getString("hash")
        var user_name : String? = SharedPreference(this).getValueString("account_username")
        if (hash != null && user_name != null) {
            ImgurCalls().delete(this, token, user_name, hash)
        }
    }
    override fun onResponse(response: ImgurModels.ResponseFavorite?) {
        if (response != null) {
        }
    }
    override fun onResponse(response: ImgurModels.ResponseDelete?) {
        if (response != null) {
        }
    }
    override fun onFailure() {

    }
}
