package com.example.sharedpreferencedemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var etEmail:EditText
    private lateinit var etPassword:EditText
    private lateinit var cbkeepMeSignIn:CheckBox
    private lateinit var btSignIn: Button
    private lateinit  var sp:SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        sp = getSharedPreferences("loginpagePreference", Context.MODE_PRIVATE)
        editor = sp.edit()

        if(sp.contains("email")){
            etEmail.setText(sp.getString("email",""))
            etPassword.setText(sp.getString("password",""))
            cbkeepMeSignIn.isChecked = sp.getBoolean("isChecked",false)
        }

        btSignIn.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val isChecked = cbkeepMeSignIn.isChecked
            editor.apply {
                putString("email",email)
                putString("password",password)
                putBoolean("isChecked",isChecked)
                apply()
            }
        }

    }



    override fun onPause() {

        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val isChecked = cbkeepMeSignIn.isChecked
        editor.apply {
            putString("email",email)
            putString("password",password)
            putBoolean("isChecked",isChecked)
            apply()
        }
        super.onPause()

    }


    fun initViews(){
        etEmail = findViewById(R.id.email)
        etPassword = findViewById(R.id.password)
        cbkeepMeSignIn = findViewById(R.id.cbKeepMeSignIn)
        btSignIn = findViewById(R.id.loginbtn)
    }
}