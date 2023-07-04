package com.example.myapplication.week2.volleyimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.R
import com.example.myapplication.week2.volleyimplementation.adapter.GithubRecyclerAdapter
import com.example.myapplication.week2.volleyimplementation.data.GithubUser
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class VolleyActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView
    private lateinit var listOfUser: ArrayList<GithubUser>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley)
        listOfUser = ArrayList()
        rv = findViewById(R.id.volleyrv)
        setUpVolley()

    }

    fun setUpVolley(){
        val url = "https://api.github.com/users"

        val queue = Volley.newRequestQueue(this)
        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET,
            url,
            null,
            {response -> parseJsonArray(response)},
            {err -> }
        )
        queue.add(jsonArrayRequest)

    }

    fun parseJsonArray(jsonArray: JSONArray){
        for(i in 0 until jsonArray.length()){
            var user = GithubUser()
            var obj : JSONObject = jsonArray.getJSONObject(i)
            user.login = obj.getString("login")
            user.avatar_url = obj.getString("avatar_url")
            user.html_url = obj.getString("html_url")
            listOfUser.add(user)
        }
        rv.adapter = GithubRecyclerAdapter(this, listOfUser)
        rv.layoutManager = LinearLayoutManager(this)
    }
}