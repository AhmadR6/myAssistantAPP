package com.ahmadr6.myassistant

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class homepage3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homepage3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val instagramAction = findViewById<CardView>(R.id.instagramCardView)
        val weatherAction = findViewById<CardView>(R.id.weatherCardView)
        val photosAction = findViewById<CardView>(R.id.photosCardView)
        val alarmAction = findViewById<CardView>(R.id.alarmCardView)
        val logoutBtn = findViewById<Button>(R.id.logoutBtnId)
        val backBtn = findViewById<Button>(R.id.backBtnId)

        instagramAction.setOnClickListener{
            val instagramIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ahmad_reh4/"))
            startActivity(instagramIntent)
        }


        weatherAction.setOnClickListener{
            val weatherIntent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.accuweather.com/en/pk/faisalabad/260626/weather-forecast/260626?city=faisalabad"))
            startActivity(weatherIntent)
        }
        photosAction.setOnClickListener{
            val photoIntent = Intent(Intent.ACTION_VIEW)
            photoIntent.type = "image/*"
            startActivity(photoIntent)

        }
        alarmAction.setOnClickListener{
            val alarmIntent = Intent(android.provider.AlarmClock.ACTION_SET_ALARM)
            startActivity(alarmIntent)
        }


        logoutBtn.setOnClickListener{
            val logoutIntent = Intent(this,MainActivity::class.java)
            startActivity(logoutIntent)
        }
        backBtn.setOnClickListener{
            val backBtnIntent = Intent(this,homePage::class.java)
            startActivity(backBtnIntent)
        }

    }
}