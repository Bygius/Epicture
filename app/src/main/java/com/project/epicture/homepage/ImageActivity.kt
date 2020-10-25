package com.project.epicture.homepage
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.epicture.R
import com.project.epicture.api.ImgurCalls
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ImageActivity : AppCompatActivity() {
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
            ImgurCalls()
        }
    }
}
