package com.example.myapplication.week1.kotlincollections

import kotlin.collections.ArrayList

fun main(){

    /*
    Two types of Arrays
        Array - its like primitive array of java, its of fixed size
        ArrayList - Dynamic array
     */


    //Creating primitive array
        //method one
    val arr1: Array<Int> = arrayOf(32,234,54,234,523);
    for(i in arr1) print("$i ")
        //method two
    val arr2: Array<Int> = Array(10, {i->i*0})
    for(i in arr2) print("$i ")
    // explaination: The constructor takes two arguments
         // first : size of array
         // second: lamda expression denoting what element should be at what index, in this eg. we created array of all zeros


    // Creating Dynamic array: ArrayList
        //method one
    val list1 : ArrayList<Int> = arrayListOf(234,2345,2,13);

        //method two
    val list2 : ArrayList<Int> = ArrayList()


    //Sorting primitive arrays
    arr1.sort()
    println(arr1.contentToString())

    //Sorting ArrayList
    println(list1.sort())


}