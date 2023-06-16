package oops


interface Downloader{




    fun download(fileName:String)

    fun downloadInfo(fileName:String){
        println("Your file name is $fileName.")
    }
}

class Chrome: Downloader{
    override fun download(fileName: String) {
        print("Downloading $fileName from Chrome browser...")
    }
}

fun main(){
    var c: Chrome = Chrome();

}