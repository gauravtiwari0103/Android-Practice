package com.example.myapplication.week1.oops


/*
Theory:
Suppose we want to add addition features/functions to the string class
the normal approach is to make new class AdvString which will inheriet all functoins of
existing String class, and then add our additional functions to the AdvString class

But kotlin makes it easy for us.

Eg. Here we will add one more function called getAllWords() to the String class
 */

fun String.getAllWords():List<String>{
    return this.split(" ")
}
fun main(){
    var a = "Lion is the king of animal kingdom"
    var list = a.getAllWords()
    println(list)
}