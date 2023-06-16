package oops

open class BaseCoffeeMachine(var price:Int, var color:String){
    open fun makeCoffee(){
        println("Enjoy ur Coffee")
    }
}

class PremiumCoffeeMachine(price:Int, color: String, var noOfTypesOfDrinks:Int): BaseCoffeeMachine(price, color){
    fun makeLatte(){
        println("Enjoy your latte")
    }

    fun makeCapuchinno(){
        println("Enjoy your cuppochino")
    }

    override fun makeCoffee(){
        println("making coffee from premium machine")
    }
}

fun main(){
    var pcm:BaseCoffeeMachine = PremiumCoffeeMachine(20000,"black",3)
}