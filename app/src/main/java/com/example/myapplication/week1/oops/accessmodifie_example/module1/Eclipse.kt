package com.example.myapplication.week1.oops.accessmodifie_example.module1

class Eclipse {
    val radius: Int = 10
    val lenght: Int = 14
}

fun main(){
    var c: Circle = Circle()
    c.env // can access the internal variable env, bcoz both are in same module
}