package com.project.epicture.api

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.FileUtils
import androidx.appcompat.app.AppCompatActivity
import com.project.epicture.utils.SharedPreference
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import android.content.Context
import android.content.pm.PackageManager
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import androidx.core.os.persistableBundleOf
import androidx.loader.content.CursorLoader

class uploadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        //val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, permissions, 10)
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 42, null)
        } else {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val shared: SharedPreference = SharedPreference(this)
        val tok = shared.getValueString("access_token")

        if (resultCode == Activity.RESULT_OK && requestCode == 42){
            if (data != null && tok != null && data.data != null) {
                var uri = data.data
                if (uri != null) {
                    postImage(uri)
                }
            }
        }
    }
    private fun getRealPathFromURI(contentUri: Uri): String? {
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val loader = CursorLoader(applicationContext, contentUri, proj, null, null, null)
        val cursor = loader.loadInBackground()
        val column_index = cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor?.moveToFirst()
        val result = cursor?.getString(column_index!!)
        cursor?.close()
        return result
    }

    fun postImage(file_uri: Uri) {
        var file : File = File(getRealPathFromURI(file_uri))
        val requestFile : RequestBody = RequestBody.create(
            MediaType.parse(getApplicationContext().getContentResolver().getType(file_uri)),
            file
        )
        var imgur = ImgurService().retrofit.create(IImgurApi::class.java)
        val body : MultipartBody.Part = MultipartBody.Part.createFormData("image", file.name, requestFile)
        val shared: SharedPreference = SharedPreference(this)
        val token = shared.getValueString("access_token")
        val call: Call<ImgurModels.ResponseImage> = imgur.postImage("Bearer $token", body)//service.upload(description, body)
        call.enqueue(object : Callback<ImgurModels.ResponseImage> {
            override fun onResponse(call: Call<ImgurModels.ResponseImage>, response: Response<ImgurModels.ResponseImage>) {
                println(response.message())
                finish()
            }
            override fun onFailure(call: Call<ImgurModels.ResponseImage>, t: Throwable) {
                println("FAIL\n")
                println(t.message + "\n")
                finish()
            }
    });
    }
}