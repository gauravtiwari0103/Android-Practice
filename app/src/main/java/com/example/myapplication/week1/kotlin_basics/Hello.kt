package com.example.myapplication.week1.kotlin_basics

fun main(){
    println("hello world!!!!!!")

    var a = 10
    val b = 11
    addTwoNums(a,b)


    // Syntax of if-else
    /*
    val age = 19
    if(age>21) println("Can drink")
    else println("Cannot Drink")
    */

    //for loop on a range
    /*
    for(i in 1..9)
        println(i)
    */


    // while loop example with input-output
    //note: For input-output we can also use scanner same as java scanner
    /*
    print("enter ur age: ")
    var age = readln().toInt()
    while(age<21){
        print("You cannot drink at this age, re-enter some other age? ")
        age = readln().toInt()
    }
    println("Now u can drink at age of $age")
    */

    //when syntax kotlin
    /*
    var livingBeing: String = readln().lowercase()
    when(livingBeing){
        "crocodile","iguana","turtle","lizard"-> println("reptile")
        "lion","tiger","leopard","human" -> println("mammal")
        "crow","eagle","hawk","sparrow" -> println("bird")
        else -> println("animal out of my database")
    }

    //when syntax using range
    var bmi : Int = readln().toInt()
    when(bmi){
        in 0..18 -> println("underweight")
        in 19..24 -> println("normal")
        in 25 .. Int.MAX_VALUE -> println("overweight")
    }
     */


    // Kotlin Type Conversion
    /*
    var intNum : Int = 34
    var longNum : Long = intNum //This is invalid operation, though it was possible in java
    var longNum2 :Long = intNum.toLong() //This is valid conversion
    var str: String = "432523"
    val longFromStr = str.toLong()
     */


    // in keyword kotlin
    /*
    val arr : ArrayList<Int> = arrayListOf(423,234,2,134,234,2,354235,23,4,123,1,32,2)
    val isThere:Boolean = 12 in arr // the code translates to arr.contains(12)
     */




}
// Syntax of normal function
fun addTwoNums(a:Int, b:Int):Int{
    return a+b
}

// another shorter syntax of function
fun addTwoNums(a:Int, b:Int,c:Int)= (a+b)
