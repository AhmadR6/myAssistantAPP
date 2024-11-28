package com.ahmadr6.myassistant

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ahmadr6.myassistant.R
import com.ahmadr6.myassistant.homePage

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val  usernameInput = findViewById<EditText>(R.id.userNameId)
        val  passwordInput = findViewById<EditText>(R.id.passwordId)
        val  loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val userName = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            if(userName ==""|| password==""){
                Toast.makeText(this, "UserName and Password can not be blank", Toast.LENGTH_SHORT).show()
            }
            else if(userName == "admin" && password == "admin123"){
                val homePageIntent = Intent(this,homePage::class.java)
                homePageIntent.putExtra("username",userName)
                homePageIntent.putExtra("password",password)
                startActivity(homePageIntent)


            }else {
                Toast.makeText(this, "Invalid UserName and PassWord", Toast.LENGTH_SHORT).show()
            }



        }
    }





}