package oops
/*
Object expression is used to make the object of an interface without making the seperate class which
implements the interface.
It is like the anonymous class of java.
 */
fun interface downloader{
    fun donwload(filename:String)
//    fun fastDownload(fileName: String)
    fun downloadInfo(filename: String){
        println("ur file name is $filename")
    }

}

fun main(){
    var objOfDownloaderInterface  = downloader{

    }
    objOfDownloaderInterface.donwload("lion")
}