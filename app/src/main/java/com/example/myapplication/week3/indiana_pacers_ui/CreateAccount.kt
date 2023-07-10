package com.example.myapplication.week3.indiana_pacers_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.data.RegisterApiResponse
import com.example.myapplication.week3.indiana_pacers_ui.data.User
import com.example.myapplication.week3.indiana_pacers_ui.interfaces.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateAccount : AppCompatActivity() {
    private lateinit var btnCreateAccount:Button
    private lateinit var ivBackButton: ImageView

    private lateinit var etFirstName: EditText
    private lateinit var etLastName:EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword:EditText
    private lateinit var etConfirmPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        initViews()


        btnCreateAccount.setOnClickListener {
            goToNextPage()
        }

        ivBackButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun goToNextPage(){
        if(!validate()) return
        val intent = Intent(this, Login::class.java)
        var user = User(
            etFirstName.text.toString(),
            etLastName.text.toString(),
            etEmail.text.toString(),
            etPassword.text.toString(),
            etConfirmPassword.text.toString()
        )
        sendRegisterationRequest(user)

    }

    private fun sendRegisterationRequest(user:User): RegisterApiResponse?{
        var resultResponse: RegisterApiResponse? = null
        val queue : Call<RegisterApiResponse> = ApiService.apiInstance.getToken(user)
        queue.enqueue(object : Callback<RegisterApiResponse>{
            override fun onFailure(call: Call<RegisterApiResponse>, t: Throwable) {
                Log.d("tag912","API Part Failded for PACERS")
            }

            override fun onResponse(
                call: Call<RegisterApiResponse>,
                response: Response<RegisterApiResponse>
            ) {
                Log.d("tag912","API Success: ${response.body()}")
                resultResponse = response.body()
                var intent = Intent(this@CreateAccount, Login::class.java)
                var token = response.body()?.token
                if(token==null || token=="null" || token=="")
                    token = "empty"
                intent.putExtra("token", token)
                startActivity(intent)
            }
        })
        return resultResponse
    }
    private fun validate():Boolean{
        //validating firstname
        var firstName = etFirstName.text.toString().trim()
        if(firstName.length < 2 || firstName.length>30){
            etFirstName.error = "Set proper first name"
            etFirstName.requestFocus()
            return false
        }
        if(containsOtherThanAlphabets(firstName)){
            etFirstName.error = "Only alphabets allowed"
            etFirstName.requestFocus()
            return false
        }

        //validating lastname
        var lastname = etLastName.text.toString().trim()
        if(lastname.length < 2 || lastname.length>30){
            etLastName.error = "Set proper last name"
            etLastName.requestFocus()
            return false
        }
        if(containsOtherThanAlphabets(lastname)){
            etLastName.error = "Only alphabets allowed"
            etLastName.requestFocus()
            return false
        }

        //validating email
        val emailRegex = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$")
        val email = etEmail.text.toString().trim()
        if(!emailRegex.matches(email)){
            etEmail.error= "Put Proper Email"
            etEmail.requestFocus()
            return false
        }

        //password
        val password = etPassword.text.toString()
        if(password.length<8){
            etPassword.error = "Password is too short"
            etPassword.requestFocus()
            return false
        }

        //confirm password
        val confirmPassword = etConfirmPassword.text.toString()
        if (confirmPassword != password){
            etConfirmPassword.error = "Password doesnt matches"
            etConfirmPassword.requestFocus()
            return false
        }

        return true
    }

    private fun containsOtherThanAlphabets(str: String):Boolean{
        for(char in str){
            if(!((char in 'a'..'z') || (char in 'A'..'Z'))) return true
        }
        return false
    }

    private fun initViews(){
        btnCreateAccount = findViewById(R.id.pacers_btn_createAccount)
        etFirstName = findViewById(R.id.pacers_et_firstname)
        ivBackButton = findViewById(R.id.pacer_appbar_iv_backbutton)
        etLastName = findViewById(R.id.pacers_et_lastname)
        etEmail = findViewById(R.id.pacers_et_email)
        etPassword = findViewById(R.id.pacers_et_password)
        etConfirmPassword = findViewById(R.id.pacers_et_confirmpassword)
    }
}