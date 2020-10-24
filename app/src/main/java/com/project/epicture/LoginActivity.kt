package com.project.epicture
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.project.epicture.R
import com.project.epicture.utils.SharedPreference

class LoginActivity : AppCompatActivity() {

    val CLIENT_ID = "f78aba81ff33038"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById<Button>(R.id.login_button).setOnClickListener {
            val url = "https://api.imgur.com/oauth2/authorize?client_id=$CLIENT_ID&response_type=token"
            val it = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(it)
        }
    }

    override public fun onResume() {
        super.onResume()
        if (intent != null && intent.getAction().equals(Intent.ACTION_VIEW)) {
            val shared: SharedPreference = SharedPreference(this)
            var uri = intent.data.toString()
            val pairs = uri.substring(uri.indexOf("#") + 1).split("&")
            for (p: String in pairs)
                shared.save(p.substring(0, p.indexOf("=")), p.substring(p.indexOf("=") + 1))
            finish()
        }
    }
}

//setResult(Activity.RESULT_CANCELED, return_intent);
//println("finish 2\n")
//finish()
/*        if (intent != null && intent.getAction().equals(Intent.ACTION_VIEW)) {
            val uri = intent.data
            var s = uri.toString()
            ////var str = s.substring(s.indexOf("#") + 1)
            //token = s.substring(s.indexOf("#") + 1)
            //println("2 ________" + token)
            var data = intent
            data.putExtra("data", s)
            //data.putExtra(Intent.EXTRA_RETURN_RESULT, true)
            if (parent == null) {
                setResult(Activity.RESULT_OK, data);
            } else {
                parent.setResult(Activity.RESULT_OK, data);
            }
            finish()
        } else if (intent.data != null) {
            val myToast = Toast.makeText(applicationContext, "An error occur !", Toast.LENGTH_SHORT)
            myToast.show()
        }*/