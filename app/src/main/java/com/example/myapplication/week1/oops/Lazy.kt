package com.example.myapplication.week1.oops
class StudentHeavy {
    var name:String = "ram"
    init {
        println("Student heavey created")
    }
}

class Studentt{
    val heavy by lazy { StudentHeavy() }
}

fun main(){
    var s: Studentt = Studentt()
    println("lafsdj")
    s.heavy
    s.heavy
}


