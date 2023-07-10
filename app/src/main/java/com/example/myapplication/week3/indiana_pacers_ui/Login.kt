package com.example.myapplication.week3.indiana_pacers_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.data.LoginCredential
import com.example.myapplication.week3.indiana_pacers_ui.data.UserLoginResponse
import com.example.myapplication.week3.indiana_pacers_ui.interfaces.ApiLogin
import com.example.myapplication.week3.indiana_pacers_ui.interfaces.LoginService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    private lateinit var tvCreateAccount : TextView
    private lateinit var etEmail:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnLogin:Button
    private lateinit var iv: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
        val token = intent.getStringExtra("token")
        
        if(token=="empty"){
            Toast.makeText(this, "user already created", Toast.LENGTH_LONG).show()
        }
        else if (token!=null && token.length>1){
            Toast.makeText(this, "user created\nToken:$token", Toast.LENGTH_LONG).show()
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
//            var loginCredential = LoginCredential(email, password)
//            login(loginCredential)
            var intent = Intent(this, Welcome::class.java)
            intent.putExtra("firstname","Gaurav")
            startActivity(intent)
            finish()
        }
        tvCreateAccount.setOnClickListener {
            startActivity(Intent(this, CreateAccount::class.java ))
        }
    }

    private fun login(loginCredential: LoginCredential){
        val queue:Call<UserLoginResponse> = LoginService.apiLoginInstance.loginWithCredential(loginCredential)
        queue.enqueue(object : Callback<UserLoginResponse>{
            override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {
                Log.d("tag912","login requeset failed")
            }

            override fun onResponse(
                call: Call<UserLoginResponse>,
                response: Response<UserLoginResponse>
            ) {
                Log.d("tag912","login Succeed: ${response.body()}")
            }
        })
    }

    private fun initViews(){
        tvCreateAccount = findViewById(R.id.tv_indiana_createAccount)
        etEmail = findViewById(R.id.pacers_login_et_email)
        etPassword = findViewById(R.id.pacers_login_et_password)
        btnLogin = findViewById(R.id.pacers_login_btn_login)
    }
}