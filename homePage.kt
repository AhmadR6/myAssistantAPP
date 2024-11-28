package com.ahmadr6.myassistant

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class homePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val callAction = findViewById<CardView>(R.id.callCardView)
        val emailAction = findViewById<CardView>(R.id.emailCardView)
        val smsAction = findViewById<CardView>(R.id.smsCardView)
        val cameraAction = findViewById<CardView>(R.id.cameraCardView)
        val settingAction = findViewById<CardView>(R.id.settingsCardView)
        val mapAction = findViewById<CardView>(R.id.mapsCardView)
        val logoutBtn = findViewById<Button>(R.id.logoutBtnId)
        val nextBtn = findViewById<Button>(R.id.nextBtnId)


        callAction.setOnClickListener{
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:3137112502"))
            startActivity(callIntent)
        }
        emailAction.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:ahmadrehman581@gmail.com"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject of Email")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body of the email")
            startActivity(Intent.createChooser(emailIntent, "Choose an email client"))
        }
        smsAction.setOnClickListener{
            val smsIntent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:3137112502"))
            startActivity(smsIntent)

        }
        cameraAction.setOnClickListener{
            val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }
        settingAction.setOnClickListener{
            val settingIntent = Intent(android.provider.Settings.ACTION_SETTINGS)
            startActivity(settingIntent)
        }
        mapAction.setOnClickListener{
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:55.4972,9.7472"))
            startActivity(mapIntent)
        }

        logoutBtn.setOnClickListener{
            val logoutIntent = Intent(this,MainActivity::class.java)
            startActivity(logoutIntent)
        }
        nextBtn.setOnClickListener{
            val nextBtnIntent = Intent(this,homepage3::class.java)
            startActivity(nextBtnIntent)
            }


    }
}