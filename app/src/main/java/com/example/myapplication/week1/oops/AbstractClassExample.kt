package com.example.myapplication.week1.oops

abstract class BaseCoffeeMachinee(var price:Int, var color:String){
    abstract fun makeCoffee()
    abstract val cost: Int


}

class PremiumCoffeeMachinee(price:Int, color:String):BaseCoffeeMachinee(price, color){
    override fun makeCoffee() {
        println("Cofee lelo")
    }

    override val cost: Int = 423


}