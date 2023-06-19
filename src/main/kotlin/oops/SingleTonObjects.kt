package oops


/*
many times there are scenerio where we want only one instance of the object throughout the application
maybe bcoz creating multiple intances of the object is expensive
so here we make singleTon objecy


 */


//normal apporach to make single ton object in other programming lang: (Kotlin also does same, but internally
// devleoper doesnt have to write boiler plate code
class SingleTonObjects private constructor(){ // we make constructor private, so it cant be created
    companion object{
        var instance: SingleTonObjects? = null

        fun getInstancee():SingleTonObjects // we will use this method to use the instance
        = synchronized(this){ // we made it even thread safe, so that multiple thread cannot make differnet instances

            if(instance!= null) instance = SingleTonObjects();
            return instance!!
        }
        // more kotlin way: we will use the invoke operator
    }
}



/*
now kotlin way of making singleton objects
 */

object Singleton{
    init {
        println("got initialized")
    }

    fun doSomething( a: String){
        //doing something
    }

    var someData = "this is some data"
}
