package com.example.myapplication.week1.oops


/*
Delegation means seperating the responsibity to different objects
 */
class Delegation {
}

interface FastDownloader{
    fun fastDownload()
}

interface Player{
    fun play()
}

class MediaFile(val fDownloader: FastDownloader, val player: Player) :
    FastDownloader by fDownloader, Player by player


/*
Look normally in MediaFile class we have to implement the methods fastDownload() and play()
but we didnt did that as we delegated the reponsibility to the objects passed with the help of `by` keyword
 */
