package com.example.myapplication.week1.oops


interface Downloaderr{




    fun download(fileName:String)

    fun downloadInfo(fileName:String){
        println("Your file name is $fileName.")
    }
}

class Chrome: Downloaderr{
    override fun download(fileName: String) {
        print("Downloading $fileName from Chrome browser...")
    }
}

fun main(){
    var c: Chrome = Chrome();

}