package oops.accessmodifie_example.module1

class Circle {

    val radius: Int = 10
    internal var env: String = "toxic"
    private var secretCode:String = "kanc234n1221!@"

    class innerClass{
        var c: Circle = Circle()
        init {
            println(c.radius)
        }
    }
}

