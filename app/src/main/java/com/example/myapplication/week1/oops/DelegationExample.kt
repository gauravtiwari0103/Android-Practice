package com.example.myapplication.week1.oops

import java.util.*
import kotlin.reflect.KProperty

/*
we want setters and getters for both first name and last name in class student
we want same validation logic in both setter and getter
but its not good practice to write same code twice
so we would create a name delegator object to for setting and getting values
 */

class Student{
    var firstNamee: String? by NameDelegate()
}

class NameDelegate{
    var formattedValue: String? = null
    operator fun setValue(
        thisRef: Any?, // has referece of the object which will have this setter,
        // here it is Student obj, we cant use it like (thisRef as Student).firstName
        property: KProperty<*>,
        //Has the metadata about the object
        value: String?
    ){
        //our logic
        println(property.name)
        if(value != null && value.length >=5){
            formattedValue = value.trim().uppercase(Locale.getDefault())
        }
    }

    operator fun getValue(thisRef: Any?, kProperty: KProperty<*>) : String? {
        return formattedValue;
    }
}


fun main(){
    var s: Student= Student()
    s.firstNamee = "Gaurav"
}