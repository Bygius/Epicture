package com.project.epicture.homepage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.project.epicture.R
import com.project.epicture.api.ImgurModels
import com.project.epicture.homepage.fragments.ProfileFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_grid.view.*

class ImageAdaptater(private val c: Context, private val images: List<ImgurModels.AccountImagesData>) :
    RecyclerView.Adapter<ImageAdaptater.ColorViewHolder>() {


    override fun getItemCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(LayoutInflater.from(c).inflate(R.layout.item_grid, parent, false))
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val path = images[position].link
        //println("------------- ${path}")

        Picasso.with(c).load(path).resize(250, 250).centerCrop().into(holder.iv)

        holder.iv.setOnClickListener {
            val intent = Intent(c, ImageActivity::class.java)
            c.startActivity(intent)
        }
    }

    class ColorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv = view.iv as ImageView
    }
}
