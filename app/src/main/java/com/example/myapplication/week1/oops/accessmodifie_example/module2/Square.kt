package com.example.myapplication.week1.oops.accessmodifie_example.module2
import com.example.myapplication.week1.oops.accessmodifie_example.module1.Circle

class Square {
    val side:Int = 10
}

fun main() {
    var c: Circle = Circle()
    c.radius  // can be accessed here in different module bcoz radius was public by default
    c.env //
}