package oops
class Box{
    val length: Int = 10
    val breadth: Int = 8
    val height: Int = 9

    fun printArea(){
        println(length * breadth * height)
    }

    fun openBox(){
        println("box opened")
    }

    fun closeBox(){
        println("box closed")
    }
}