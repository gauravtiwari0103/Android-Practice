package com.example.myapplication.week1.oops

class Lion constructor(var age:Int = 10, var weight:Int = 250, var gender:String = "male"){
    var bool: Boolean = false
    init {
        println("a new lion is created")
    }


    constructor(age: Int): this(0,0,"male"){
        println("secondry constructor called")
        this.age = age
        bool = false
    }

}

fun main() {
    var lion: Lion = Lion(13)
    println(lion.age)

}