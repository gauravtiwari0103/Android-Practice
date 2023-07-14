package com.example.myapplication.week3.contentProviderDemo

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ContentProviderDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider_demo)
        if (!hasContactPermission()) requestContactPermission()
        val list = ContactReader.doMagicContacts(this)
        val rv = findViewById<RecyclerView>(R.id.contentProviderRv)
        rv.adapter = ContactAdapter(list)
        rv.layoutManager = LinearLayoutManager(this)

    }


    private fun hasContactPermission(): Boolean {
        val permission = Manifest.permission.READ_CONTACTS
        val result = ContextCompat.checkSelfPermission(this, permission)
        return result == PackageManager.PERMISSION_GRANTED
    }

    private fun requestContactPermission() {
        val permission = Manifest.permission.READ_CONTACTS
        val requestCode = 123 // You can use any unique value here

        ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 123) { // Use the same request code used in the requestContactPermission() method
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show()
            }
        }
    }


}