package com.example.myapplication.week3.contentProviderDemo

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract
import android.util.Log


object ContactReader {


    @SuppressLint("Range")
    public fun doMagicContacts(context:Context):ArrayList<Contact> {
        val list = ArrayList<Contact>()
        Log.d("tag912","in do magic function")
        val cursor: Cursor = context.contentResolver
            .query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                null
            ) ?: return ArrayList<Contact>()
        Log.d("tag912","cursor created")
        cursor.moveToFirst()
        do {
            val name = cursor.getString(
                cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
            )
            Log.d("tag912","name: $name")
            val id = cursor.getString(
                cursor.getColumnIndex(ContactsContract.Contacts.NAME_RAW_CONTACT_ID)
            )
            Log.d("tag912","id: $id")
            val phones: Cursor = context.contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Phone.RAW_CONTACT_ID + " = " + id,
                null,
                null
            )!!
            if (phones != null) {
                while (phones.moveToNext()) {
                    val phoneNumber = phones.getString(
                        phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                    )
                    Log.d("tag912", "doMagicContacts: $name $phoneNumber")
                    list.add(Contact(name, phoneNumber))
                }
                phones.close()
            }
        } while (cursor.moveToNext())
        cursor.close()
        return list
    }
}